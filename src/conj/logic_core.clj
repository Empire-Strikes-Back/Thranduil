(ns conj.logic-core
  (:require [clojure.repl :refer :all]
            [clojure.pprint :as pp]
            [conj.logic-dev-server]
            [conj.logic-clara]
            [conj.logic-rabbitmq]
            [conj.logic]
            [conj.logic-datomic]
            
            [conj.little-schemer]
            [conj.seasoned-schemer]
            [conj.reasoned-schemer]
            [conj.logic-req-res]
            
            
            [conj.logic-dev-nrepl]))


(defn -main []
  (conj.logic-dev-nrepl/-main)
  (conj.logic-dev-server/run-dev))


(comment
  
  (+)
  
  (defn hi [] "hi")
  
  (conj.logic-req-res/hi)
  
  )