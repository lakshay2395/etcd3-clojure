(ns etcd3-clojure.utils.pool
  (:require [clojure.core.async :refer [>!! <!! chan close!]]))

(defprotocol PoolObjectFactory
  (create-object [this]))

(defprotocol ObjectWrapperSpec
  (get-object [this])
  (release-object [this]))

(defrecord ObjectWrapper [object-holder object-factory]
  ObjectWrapperSpec

  (get-object [this]
    (when (nil? @object-holder)
      (reset! object-holder (.create-object object-factory)))
    @object-holder)

  (release-object [this]
    (when-not (nil? @object-holder)
      (reset! object-holder nil))))

(defprotocol Poolable
  (borrow [this])
  (return [this object])
  (close  [this]))

(defrecord Pool [pool-holder]
  Poolable

  (borrow [this]
    (<!! pool-holder))

  (return [this object]
    (>!! pool-holder object))

  (close [this]
    (close! pool-holder)))

(defn create-pool [object-factory ^Integer pool-size]
  (if-not (satisfies? PoolObjectFactory object-factory)
    (throw (Exception. "object-factory argument does not satisfy PoolObjectFactory")))
  (let [pool-holder (chan pool-size)]
    (dotimes [n pool-size]
      (>!! pool-holder (ObjectWrapper. (atom nil) object-factory)))
    (Pool. pool-holder)))