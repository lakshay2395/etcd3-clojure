(ns etcd3-clojure.utils.utils
  (:import (org.apache.commons.validator.routines UrlValidator)))

(defn rotate
  "Take a collection and left rotates it n steps. If n is negative,
  the
  collection is rotated right. Executes in O(n) time."
  [n coll]
  (let [c (count coll)]
    (take c (drop (mod n c) (cycle coll)))))

(defn try-times*
  "Executes thunk. If an exception is thrown, will retry. At most n retries
  are done. If still some exception is thrown it is bubbled upwards in
  the call chain."
  [n thunk]
  (loop [n n]
    (if-let [result (try
                      [(thunk)]
                      (catch Exception e
                        (when (zero? n)
                          (throw e))))]
      (result 0)
      (recur (dec n)))))

(defmacro try-times
  "Executes body. If an exception is thrown, will retry. At most n retries
  are done. If still some exception is thrown it is bubbled upwards in
  the call chain."
  [n & body]
  `(try-times* ~n (fn [] ~@body)))

(defn validate [endpoints pool-size max-conn-retries]
  (if (<= pool-size 0)
    (throw (IllegalArgumentException. "Pool size cannot be less than or equal to zero")))
  (if (<= max-conn-retries 0)
    (throw (IllegalArgumentException. "Max connection retries cannot be less than or equal to zero")))
  (if (zero? (count endpoints))
    (throw (IllegalArgumentException. "List of endpoints cannot be empty")))
  (let [default-validator (UrlValidator.)]
    (map endpoints (fn [item]
                     (if (not (.isValid default-validator item))
                       (throw (IllegalArgumentException. "Invalid endpoint - " item)))))))