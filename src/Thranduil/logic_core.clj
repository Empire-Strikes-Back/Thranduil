(ns Thranduil.logic-core
  (:require [clojure.repl :refer :all]
            [clojure.pprint :as pp]
            [Thranduil.logic-dev-server]
            [Thranduil.logic-clara]
            [Thranduil.logic-rabbitmq]
            [Thranduil.logic]
            [Thranduil.logic-datomic]

            [Thranduil.logic-req-res]


            [Thranduil.logic-dev-nrepl]))


(defn -main []
  (Thranduil.logic-dev-nrepl/-main)
  (Thranduil.logic-dev-server/run-dev))

(comment

  (require '[Thranduil.reasoned-schemer])
  (require '[Thranduil.seasoned-schemer])
  (require '[Thranduil.little-schemer])

  ;
  )


(comment
  
  (+)
  
  (defn hi [] "hi")
  
  (Thranduil.logic-req-res/hi)
  
  )