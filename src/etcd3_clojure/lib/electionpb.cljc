;;;----------------------------------------------------------------------------------
;;; Generated by protoc-gen-clojure.  DO NOT EDIT
;;;
;;; Message Implementation of package electionpb
;;;----------------------------------------------------------------------------------
(ns etcd3-clojure.lib.electionpb
  (:require [protojure.protobuf.protocol :as pb]
            [protojure.protobuf.serdes.core :refer :all]
            [protojure.protobuf.serdes.complex :refer :all]
            [protojure.protobuf.serdes.utils :refer [tag-map]]
            [protojure.protobuf.serdes.stream :as stream]
            [etcd3-clojure.lib.mvccpb :as mvccpb]
            [etcd3-clojure.lib.etcdserverpb :as etcdserverpb]
            [clojure.set :as set]
            [clojure.spec.alpha :as s]))

;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Forward declarations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

(declare cis->CampaignResponse)
(declare ecis->CampaignResponse)
(declare new-CampaignResponse)
(declare cis->CampaignRequest)
(declare ecis->CampaignRequest)
(declare new-CampaignRequest)
(declare cis->ResignResponse)
(declare ecis->ResignResponse)
(declare new-ResignResponse)
(declare cis->ProclaimResponse)
(declare ecis->ProclaimResponse)
(declare new-ProclaimResponse)
(declare cis->LeaderKey)
(declare ecis->LeaderKey)
(declare new-LeaderKey)
(declare cis->LeaderRequest)
(declare ecis->LeaderRequest)
(declare new-LeaderRequest)
(declare cis->ResignRequest)
(declare ecis->ResignRequest)
(declare new-ResignRequest)
(declare cis->ProclaimRequest)
(declare ecis->ProclaimRequest)
(declare new-ProclaimRequest)
(declare cis->LeaderResponse)
(declare ecis->LeaderResponse)
(declare new-LeaderResponse)


;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------
;; Message Implementations
;;----------------------------------------------------------------------------------
;;----------------------------------------------------------------------------------

;-----------------------------------------------------------------------------
; CampaignResponse
;-----------------------------------------------------------------------------
(defrecord CampaignResponse [header leader]
  pb/Writer

  (serialize [this os]
    (write-embedded 1 (:header this) os)
    (write-embedded 2 (:leader this) os)))

(s/def ::CampaignResponse-spec (s/keys :opt-un []))
(def CampaignResponse-defaults {})

(defn cis->CampaignResponse
  "CodedInputStream to CampaignResponse"
  [is]
  (->> (tag-map CampaignResponse-defaults
         (fn [tag index]
             (case index
               1 [:header (etcd3-clojure.lib.etcdserverpb/ecis->ResponseHeader is)]
               2 [:leader (ecis->LeaderKey is)]

               [index (cis->undefined tag is)]))
         is)
        (map->CampaignResponse)))

(defn ecis->CampaignResponse
  "Embedded CodedInputStream to CampaignResponse"
  [is]
  (cis->embedded cis->CampaignResponse is))

(defn new-CampaignResponse
  "Creates a new instance from a map, similar to map->CampaignResponse except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::CampaignResponse-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::CampaignResponse-spec init))))]}
  (-> (merge CampaignResponse-defaults init)
      (cond-> (contains? init :header) (update :header etcd3-clojure.lib.etcdserverpb/new-ResponseHeader))
      (cond-> (contains? init :leader) (update :leader new-LeaderKey))
      (map->CampaignResponse)))

(defn pb->CampaignResponse
  "Protobuf to CampaignResponse"
  [input]
  (cis->CampaignResponse (stream/new-cis input)))

;-----------------------------------------------------------------------------
; CampaignRequest
;-----------------------------------------------------------------------------
(defrecord CampaignRequest [name lease value]
  pb/Writer

  (serialize [this os]
    (write-Bytes 1  {:optimize true} (:name this) os)
    (write-Int64 2  {:optimize true} (:lease this) os)
    (write-Bytes 3  {:optimize true} (:value this) os)))

(s/def :electionpb.messages.CampaignRequest/name bytes?)
(s/def :electionpb.messages.CampaignRequest/lease int?)
(s/def :electionpb.messages.CampaignRequest/value bytes?)
(s/def ::CampaignRequest-spec (s/keys :opt-un [:electionpb.messages.CampaignRequest/name :electionpb.messages.CampaignRequest/lease :electionpb.messages.CampaignRequest/value ]))
(def CampaignRequest-defaults {:name (byte-array 0) :lease 0 :value (byte-array 0) })

(defn cis->CampaignRequest
  "CodedInputStream to CampaignRequest"
  [is]
  (->> (tag-map CampaignRequest-defaults
         (fn [tag index]
             (case index
               1 [:name (cis->Bytes is)]
               2 [:lease (cis->Int64 is)]
               3 [:value (cis->Bytes is)]

               [index (cis->undefined tag is)]))
         is)
        (map->CampaignRequest)))

(defn ecis->CampaignRequest
  "Embedded CodedInputStream to CampaignRequest"
  [is]
  (cis->embedded cis->CampaignRequest is))

(defn new-CampaignRequest
  "Creates a new instance from a map, similar to map->CampaignRequest except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::CampaignRequest-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::CampaignRequest-spec init))))]}
  (-> (merge CampaignRequest-defaults init)
      (map->CampaignRequest)))

(defn pb->CampaignRequest
  "Protobuf to CampaignRequest"
  [input]
  (cis->CampaignRequest (stream/new-cis input)))

;-----------------------------------------------------------------------------
; ResignResponse
;-----------------------------------------------------------------------------
(defrecord ResignResponse [header]
  pb/Writer

  (serialize [this os]
    (write-embedded 1 (:header this) os)))

(s/def ::ResignResponse-spec (s/keys :opt-un []))
(def ResignResponse-defaults {})

(defn cis->ResignResponse
  "CodedInputStream to ResignResponse"
  [is]
  (->> (tag-map ResignResponse-defaults
         (fn [tag index]
             (case index
               1 [:header (etcd3-clojure.lib.etcdserverpb/ecis->ResponseHeader is)]

               [index (cis->undefined tag is)]))
         is)
        (map->ResignResponse)))

(defn ecis->ResignResponse
  "Embedded CodedInputStream to ResignResponse"
  [is]
  (cis->embedded cis->ResignResponse is))

(defn new-ResignResponse
  "Creates a new instance from a map, similar to map->ResignResponse except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::ResignResponse-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::ResignResponse-spec init))))]}
  (-> (merge ResignResponse-defaults init)
      (cond-> (contains? init :header) (update :header etcd3-clojure.lib.etcdserverpb/new-ResponseHeader))
      (map->ResignResponse)))

(defn pb->ResignResponse
  "Protobuf to ResignResponse"
  [input]
  (cis->ResignResponse (stream/new-cis input)))

;-----------------------------------------------------------------------------
; ProclaimResponse
;-----------------------------------------------------------------------------
(defrecord ProclaimResponse [header]
  pb/Writer

  (serialize [this os]
    (write-embedded 1 (:header this) os)))

(s/def ::ProclaimResponse-spec (s/keys :opt-un []))
(def ProclaimResponse-defaults {})

(defn cis->ProclaimResponse
  "CodedInputStream to ProclaimResponse"
  [is]
  (->> (tag-map ProclaimResponse-defaults
         (fn [tag index]
             (case index
               1 [:header (etcd3-clojure.lib.etcdserverpb/ecis->ResponseHeader is)]

               [index (cis->undefined tag is)]))
         is)
        (map->ProclaimResponse)))

(defn ecis->ProclaimResponse
  "Embedded CodedInputStream to ProclaimResponse"
  [is]
  (cis->embedded cis->ProclaimResponse is))

(defn new-ProclaimResponse
  "Creates a new instance from a map, similar to map->ProclaimResponse except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::ProclaimResponse-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::ProclaimResponse-spec init))))]}
  (-> (merge ProclaimResponse-defaults init)
      (cond-> (contains? init :header) (update :header etcd3-clojure.lib.etcdserverpb/new-ResponseHeader))
      (map->ProclaimResponse)))

(defn pb->ProclaimResponse
  "Protobuf to ProclaimResponse"
  [input]
  (cis->ProclaimResponse (stream/new-cis input)))

;-----------------------------------------------------------------------------
; LeaderKey
;-----------------------------------------------------------------------------
(defrecord LeaderKey [name key rev lease]
  pb/Writer

  (serialize [this os]
    (write-Bytes 1  {:optimize true} (:name this) os)
    (write-Bytes 2  {:optimize true} (:key this) os)
    (write-Int64 3  {:optimize true} (:rev this) os)
    (write-Int64 4  {:optimize true} (:lease this) os)))

(s/def :electionpb.messages.LeaderKey/name bytes?)
(s/def :electionpb.messages.LeaderKey/key bytes?)
(s/def :electionpb.messages.LeaderKey/rev int?)
(s/def :electionpb.messages.LeaderKey/lease int?)
(s/def ::LeaderKey-spec (s/keys :opt-un [:electionpb.messages.LeaderKey/name :electionpb.messages.LeaderKey/key :electionpb.messages.LeaderKey/rev :electionpb.messages.LeaderKey/lease ]))
(def LeaderKey-defaults {:name (byte-array 0) :key (byte-array 0) :rev 0 :lease 0 })

(defn cis->LeaderKey
  "CodedInputStream to LeaderKey"
  [is]
  (->> (tag-map LeaderKey-defaults
         (fn [tag index]
             (case index
               1 [:name (cis->Bytes is)]
               2 [:key (cis->Bytes is)]
               3 [:rev (cis->Int64 is)]
               4 [:lease (cis->Int64 is)]

               [index (cis->undefined tag is)]))
         is)
        (map->LeaderKey)))

(defn ecis->LeaderKey
  "Embedded CodedInputStream to LeaderKey"
  [is]
  (cis->embedded cis->LeaderKey is))

(defn new-LeaderKey
  "Creates a new instance from a map, similar to map->LeaderKey except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::LeaderKey-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::LeaderKey-spec init))))]}
  (-> (merge LeaderKey-defaults init)
      (map->LeaderKey)))

(defn pb->LeaderKey
  "Protobuf to LeaderKey"
  [input]
  (cis->LeaderKey (stream/new-cis input)))

;-----------------------------------------------------------------------------
; LeaderRequest
;-----------------------------------------------------------------------------
(defrecord LeaderRequest [name]
  pb/Writer

  (serialize [this os]
    (write-Bytes 1  {:optimize true} (:name this) os)))

(s/def :electionpb.messages.LeaderRequest/name bytes?)
(s/def ::LeaderRequest-spec (s/keys :opt-un [:electionpb.messages.LeaderRequest/name ]))
(def LeaderRequest-defaults {:name (byte-array 0) })

(defn cis->LeaderRequest
  "CodedInputStream to LeaderRequest"
  [is]
  (->> (tag-map LeaderRequest-defaults
         (fn [tag index]
             (case index
               1 [:name (cis->Bytes is)]

               [index (cis->undefined tag is)]))
         is)
        (map->LeaderRequest)))

(defn ecis->LeaderRequest
  "Embedded CodedInputStream to LeaderRequest"
  [is]
  (cis->embedded cis->LeaderRequest is))

(defn new-LeaderRequest
  "Creates a new instance from a map, similar to map->LeaderRequest except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::LeaderRequest-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::LeaderRequest-spec init))))]}
  (-> (merge LeaderRequest-defaults init)
      (map->LeaderRequest)))

(defn pb->LeaderRequest
  "Protobuf to LeaderRequest"
  [input]
  (cis->LeaderRequest (stream/new-cis input)))

;-----------------------------------------------------------------------------
; ResignRequest
;-----------------------------------------------------------------------------
(defrecord ResignRequest [leader]
  pb/Writer

  (serialize [this os]
    (write-embedded 1 (:leader this) os)))

(s/def ::ResignRequest-spec (s/keys :opt-un []))
(def ResignRequest-defaults {})

(defn cis->ResignRequest
  "CodedInputStream to ResignRequest"
  [is]
  (->> (tag-map ResignRequest-defaults
         (fn [tag index]
             (case index
               1 [:leader (ecis->LeaderKey is)]

               [index (cis->undefined tag is)]))
         is)
        (map->ResignRequest)))

(defn ecis->ResignRequest
  "Embedded CodedInputStream to ResignRequest"
  [is]
  (cis->embedded cis->ResignRequest is))

(defn new-ResignRequest
  "Creates a new instance from a map, similar to map->ResignRequest except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::ResignRequest-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::ResignRequest-spec init))))]}
  (-> (merge ResignRequest-defaults init)
      (cond-> (contains? init :leader) (update :leader new-LeaderKey))
      (map->ResignRequest)))

(defn pb->ResignRequest
  "Protobuf to ResignRequest"
  [input]
  (cis->ResignRequest (stream/new-cis input)))

;-----------------------------------------------------------------------------
; ProclaimRequest
;-----------------------------------------------------------------------------
(defrecord ProclaimRequest [leader value]
  pb/Writer

  (serialize [this os]
    (write-embedded 1 (:leader this) os)
    (write-Bytes 2  {:optimize true} (:value this) os)))

(s/def :electionpb.messages.ProclaimRequest/value bytes?)
(s/def ::ProclaimRequest-spec (s/keys :opt-un [:electionpb.messages.ProclaimRequest/value ]))
(def ProclaimRequest-defaults {:value (byte-array 0) })

(defn cis->ProclaimRequest
  "CodedInputStream to ProclaimRequest"
  [is]
  (->> (tag-map ProclaimRequest-defaults
         (fn [tag index]
             (case index
               1 [:leader (ecis->LeaderKey is)]
               2 [:value (cis->Bytes is)]

               [index (cis->undefined tag is)]))
         is)
        (map->ProclaimRequest)))

(defn ecis->ProclaimRequest
  "Embedded CodedInputStream to ProclaimRequest"
  [is]
  (cis->embedded cis->ProclaimRequest is))

(defn new-ProclaimRequest
  "Creates a new instance from a map, similar to map->ProclaimRequest except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::ProclaimRequest-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::ProclaimRequest-spec init))))]}
  (-> (merge ProclaimRequest-defaults init)
      (cond-> (contains? init :leader) (update :leader new-LeaderKey))
      (map->ProclaimRequest)))

(defn pb->ProclaimRequest
  "Protobuf to ProclaimRequest"
  [input]
  (cis->ProclaimRequest (stream/new-cis input)))

;-----------------------------------------------------------------------------
; LeaderResponse
;-----------------------------------------------------------------------------
(defrecord LeaderResponse [header kv]
  pb/Writer

  (serialize [this os]
    (write-embedded 1 (:header this) os)
    (write-embedded 2 (:kv this) os)))

(s/def ::LeaderResponse-spec (s/keys :opt-un []))
(def LeaderResponse-defaults {})

(defn cis->LeaderResponse
  "CodedInputStream to LeaderResponse"
  [is]
  (->> (tag-map LeaderResponse-defaults
         (fn [tag index]
             (case index
               1 [:header (etcd3-clojure.lib.etcdserverpb/ecis->ResponseHeader is)]
               2 [:kv (mvccpb/ecis->KeyValue is)]

               [index (cis->undefined tag is)]))
         is)
        (map->LeaderResponse)))

(defn ecis->LeaderResponse
  "Embedded CodedInputStream to LeaderResponse"
  [is]
  (cis->embedded cis->LeaderResponse is))

(defn new-LeaderResponse
  "Creates a new instance from a map, similar to map->LeaderResponse except that
  it properly accounts for nested messages, when applicable.
  "
  [init]
  {:pre [(if (s/valid? ::LeaderResponse-spec init) true (throw (ex-info "Invalid input" (s/explain-data ::LeaderResponse-spec init))))]}
  (-> (merge LeaderResponse-defaults init)
      (cond-> (contains? init :header) (update :header etcd3-clojure.lib.etcdserverpb/new-ResponseHeader))
      (cond-> (contains? init :kv) (update :kv mvccpb/new-KeyValue))
      (map->LeaderResponse)))

(defn pb->LeaderResponse
  "Protobuf to LeaderResponse"
  [input]
  (cis->LeaderResponse (stream/new-cis input)))

