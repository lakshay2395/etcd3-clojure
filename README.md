# etcd3-clojure

A lightweight clojure library designed to support connection and operations to etcd3 cluster. 

## Usage

- Basic example to use the library

```
;;(:require [etcd3-clojure.core :refer :all]
;;          [etcd3-clojure.lib.etcdserverpb.KV.client :as kv-client])

(def pool (get-pool ["http://localhost:3379" "http://localhost:4379" "http://localhost:5379"] 2 2))
(with-connection pool [conn]
               @(kv-client/Put conn {:key (.getBytes "yoro") :value (.getBytes "ralle")}))
(with-connection pool [conn]
               @(kv-client/Put conn {:key (.getBytes "yoro2") :value (.getBytes "ralle2")}))
(with-connection pool [conn]
               @(kv-client/Put conn {:key (.getBytes "yoro3") :value (.getBytes "ralle3")}))
(.close pool)
```

- Important points 
    - Protos under `resources` folder have been used to auto-generate GRPC stubs for etcd3
    - A copy of docker compose for etcd3 cluster setup has been provided as a bonus

## License

Copyright (c) 2020 Lakshay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
