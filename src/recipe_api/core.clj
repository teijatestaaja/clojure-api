
(ns recipe-api.core
  (:require [compojure.api.sweet :refer [defapi context GET POST]]
            [compojure.api.swagger :refer [swagger-ui swagger-docs]]
            [ring.util.http-response :refer :all]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :refer [run-jetty]]
            [next.jdbc :as jdbc]
            [next.jdbc.sql :as sql])
  (:gen-class))

;; SQLite DB setup
(def db-spec {:dbtype "sqlite" :dbname "recipes.db"})
(def ds (jdbc/get-datasource db-spec))

;; Create table if not exists
(defn init-db []
  (jdbc/execute! ds ["CREATE TABLE IF NOT EXISTS recipes (id INTEGER PRIMARY KEY, name TEXT)"]))

;; API definition
(defapi app
  (swagger-ui {:url "/swagger.json"})
  (swagger-docs
   {:info {:title "Recipe API"
           :description "Simple API with SQLite"}})

  (context "/recipes" []
    :tags ["recipes"]

    (GET "/" []
      :summary "List all recipes"
      (ok (sql/query ds ["SELECT * FROM recipes"])))

    (POST "/" []
      :summary "Add a new recipe"
      :body-params [name :- String]
      (let [result (sql/insert! ds :recipes {:name name})]
        (ok result)))))

(defn -main []
  (println "Starting server on http://localhost:3000")
  (init-db)
  (run-jetty (wrap-defaults #'app site-defaults) {:port 3000 :join? false}))