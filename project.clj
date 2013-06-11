(defproject hello-world "0.1.0-SNAPSHOT"
  :description "Simple hello world web application"
  :main hello_world.core
  :aot :all
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/tools.logging "0.2.3"]
                 [ring/ring-core "1.1.8"]
                 [ring/ring-jetty-adapter "1.1.8"]
                 [compojure "1.1.5"]])
