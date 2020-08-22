(ns etcd3-clojure.core-test
  (:require [clojure.test :refer :all]
            [etcd3-clojure.core :refer :all]))

(deftest pool-config-validation-test

  (testing "has empty endpoints"
    (let [endpoints []
          pool-size 2
          max-conn-retries 2]
      (is (thrown? IllegalArgumentException (etcd3-clojure.core/get-pool endpoints pool-size max-conn-retries)))))

  (testing "has invalid pool size"
    (let [endpoints ["http://localhost:3379" "http://localhost:4379" "http://localhost:5379"]
          pool-size 0
          max-conn-retries 2]
      (is (thrown? IllegalArgumentException (etcd3-clojure.core/get-pool endpoints pool-size max-conn-retries)))))

  (testing "has invalid max connection retries"
    (let [endpoints ["http://localhost:3379" "http://localhost:4379" "http://localhost:5379"]
          pool-size 2
          max-conn-retries 0]
      (is (thrown? IllegalArgumentException (etcd3-clojure.core/get-pool endpoints pool-size max-conn-retries)))))

  (testing "has invalid url"
    (let [endpoints ["http://localhost:3379" "h//localhost:4379" "http://localhost:5379"]
          pool-size 2
          max-conn-retries 0]
      (is (thrown? IllegalArgumentException (etcd3-clojure.core/get-pool endpoints pool-size max-conn-retries))))))