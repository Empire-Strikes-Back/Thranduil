(ns Thranduil.lein-basics)


(defn triplicate [f & args] (f args) (f args) (f args))

(defn say [x] (println "say, " x))

(comment

  (triplicate hello)

  (triplicate say "hey")

  (def palyers {:a 1 :b 2})

  (:a palyers)

  (:d palyers)

  (def company
    {:name "WidgetCo"
     :address {:street "123 Main St"
               :city "Springfield"
               :state "IL"}})

  (get-in company [:address :city])

  (assoc-in company [:address :street] "asdasd")

  ;
  )
