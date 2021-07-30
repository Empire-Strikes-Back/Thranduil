
(+ 1 1)

(ns conj.lein-datomic
  (:require [datomic.api :as d]))

(def  uri "datomic:free://localhost:5334/git")


(d/create-database uri)


