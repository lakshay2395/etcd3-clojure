(ns etcd3-clojure.core
  (:require [protojure.grpc.client.providers.http2 :as grpc.http2]
            [etcd3-clojure.utils.pool :as pp]
            [etcd3-clojure.utils.utils :as u]
            [etcd3-clojure.lib.etcdserverpb.KV.client :as kv-client]
            [protojure.grpc.client.providers.http2 :as grpc.http2]))

(defrecord GRPCPoolObject [cluster-urls max-conn-retries]
  pp/PoolObjectFactory

  (create-object [this]
    (u/try-times max-conn-retries
                 (reset! cluster-urls (u/rotate 1 @cluster-urls))
                 (let [url (first @cluster-urls)]
                   @(grpc.http2/connect {:uri url})))))

(defn- create-connection-factory [endpoints max-conn-retries]
  (let [urls-atom (atom endpoints)]
    (GRPCPoolObject. urls-atom max-conn-retries)))

(defn get-pool [endpoints pool-size max-conn-retries]
  "Returns a etcd3 connection pool"
  (u/validate endpoints pool-size max-conn-retries)
  (pp/create-pool (create-connection-factory endpoints max-conn-retries) pool-size))

(defmacro with-connection
  "Macro to support pool based etcd3 cluster connection"
  [pool [connection] & body]
  `(let [wrapper# (.borrow ~pool)
         ~connection (.get-object wrapper#)]
     ~@body
     (.disconnect ~connection)
     (.release-object wrapper#)
     (.return ~pool wrapper#)))