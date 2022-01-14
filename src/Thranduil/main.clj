(ns Thranduil.main
  (:require
   [Thranduil.nrepl-server]
   [clojure.repl :refer :all]
   [clojure.pprint :as pp]
   [Thranduil.reference]
   [Thranduil.guides]
   [Thranduil.guides-spec]
   [Thranduil.guides-reader-cond]

   [Thranduil.logic]
   [Thranduil.logic-req-res]
   [Thranduil.logic-rabbitmq]
   [Thranduil.logic-dev-service]
   [Thranduil.logic-dev-server]
   [Thranduil.logic-dev-routes]
   [Thranduil.logic-dev-nrepl]
   [Thranduil.logic-datomic]
   [Thranduil.logic-core]
   [Thranduil.logic-clara]
   [Thranduil.logic-clara-examples]
   [Thranduil.logic-clara-examples-sensors]
   [Thranduil.logic-clara-examples-basic]

   [Thranduil.load-mbrainz]
   [Thranduil.lein]
   [Thranduil.lein-protocols]
   [Thranduil.lein-datomic]
   [Thranduil.lein-clj-data-structures-1]
   [Thranduil.lein-clj-data-structures-2]
   [Thranduil.lein-basics]
   [Thranduil.learn]
   [Thranduil.learn-syntax]
   [Thranduil.learn-seq]
   [Thranduil.learn-repl]
   [Thranduil.learn-repl-enhanced]
   [Thranduil.learn-ns]
   [Thranduil.learn-hashed]
   [Thranduil.learn-functions]
   [Thranduil.learn-flow]
   [Thranduil.hello]
   
   [Thranduil.dq]
   [Thranduil.dev]
   
   [Thranduil.datomic]
   
   [Thranduil.create-dbs]
   
   ))




(defn -main []
  (Thranduil.nrepl-server/-main))

(comment

  (require '[Thranduil.reasoned-schemer])
  (require '[Thranduil.seasoned-schemer])
  (require '[Thranduil.little-schemer])

  ;
  )