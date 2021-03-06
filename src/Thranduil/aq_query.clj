(ns Thranduil.aq-query
  (:require [clojure.repl :refer :all]
            [datomic.api :as d]
            [Thranduil.aq-conn :refer [conn cdb]]
            [clojure.pprint :as pp]
            ))


(defn get-paginted-entity
  "Returns entities and total count given limit,offset and attribute keword"
  [{:keys [attribute limit offset]
    :or {limit 10 offset 0}}]
  {:entities (->>
              (d/q '{:find [?e (count ?e)]
                     :in [$ ?attribute]
                     :where [[?e ?attribute]]}
                   (cdb) attribute)
              (drop offset)
              (take limit)
              (map  #(identity (d/pull (cdb) '[*] (first %))))
              (into [])
              )
   :count (d/q '{:find [(count ?e) .]
                 :in [$ ?attribute]
                 :where [[?e ?attribute]]}
               (cdb) attribute)
   }
  )




(comment

  (d/q '{:find [(count ?e) .]
         :where [[?e :artist/name]]}
       (cdb))

  (->>
   (get-paginted-entity {:attribute :artist/name 
                         :limit 1
                         })
   (pp/pprint)
   )
  (int "1")
  (Integer/parseInt "1")

  (doc get-paginted-entity)  

  
  (defn parse-int [number-string]
    (try (Integer/parseInt number-string)
         (catch Exception e nil)))

  (or (parse-int nil) 10)
  
  (str {:a 3 :fmt "edn"})

  (str {:data
        {:entities
         [{:artist/sortName "Tolonen, Jukka"
           :artist/name "Jukka Tolonen"
           :artist/type {:db/id 17592186045423}
           :artist/country {:db/id 17592186045496}
           :artist/gid #uuid "e129cf44-d385-497e-872a-0dc2704a4687"
           :artist/startDay 16
           :artist/startYear 1952
           :db/id 532163627856129
           :artist/startMonth 4
           :artist/gender {:db/id 17592186045420}}]
         :count 4601}
        :request-data
        {:attribute :artist/name, :limit 1, :offset 110, :fmt "edn", :x 3}
        :random 0.4632261335824779
        :uuid #uuid "5c568d20-f137-4ebc-9337-005139249971"})
  
  )