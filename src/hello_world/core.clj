(ns hello-world.core
  (:gen-class)
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [clojure.tools.logging :as log]
            [compojure.core :refer [defroutes GET]]))

;; A ring application is a function which takes a request map, and
;; returns a response map

;; Our first response map will have the HTTP status code 200, OK, a
;; content-type header that tells the browser that it's getting plain text
;; and a traditional body text.

(defn my-hello-world-ring-app [request]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello World Web Application with Ring!\n"})


;; Running server from a web application
;(defonce server (ring.adapter.jetty/run-jetty #'my-hello-world-ring-app {:port 8081 :join? false}))


(defroutes routes
  (GET "/hello" []
       {:status 200
        :header {"Content-Type" "text/plain"}
        :body "Hello World with ring.adaptor.jetty and compojure !\n"}))


;; Running server from Compojure defroutes
(defonce server (ring.adapter.jetty/run-jetty #'routes {:port 8081 :join? false}))


;; Three things to note here:
;;
;; :join? false means that the evaluating thread won't wait for the
;; server to finish (so that the repl doesn't seem to hang).
;;
;; referring to the application function via #' means that ring sees
;; the variable user/app rather than the function (fn[x]{:status 200})
;; which that variable evaluates to. And that means that if we
;; reevaluate the definition, the behaviour the browser sees will
;; change.
;;
;; finally defonce means that if we reload this file, or re-evaluate
;; this line, nothing will happen. That prevents us from accidentally
;; creating multiple copies of the jetty server.


(defn -main [& args]
  (log/info "System starting."))


