
(+ 1 1)

(ns Thranduil.lein-datomic
  (:require [datomic.api :as d]))

(comment


  (def  uri "datomic:free://localhost:5334/git")


  (d/create-database uri)


  ;
  )