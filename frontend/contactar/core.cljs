(ns contactar.core
  (:require [reagent.core :as r]
            [o2w.api.core :as api]
            [o2w.forms.core :as forms]
            [clojure.set :as set]))

(defn page []
  [:div
   [:h1 "Contacto"]])
