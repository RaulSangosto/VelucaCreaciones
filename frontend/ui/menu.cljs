(ns ui.menu
  (:require [o2w.routes :as routes]))

(defn default []
  [:div
   [:ul.menu
    [:li [:a {:href (routes/url :copas)} "copas"]]
    [:li [:a {:href (routes/url :contactar)} "contactar"]]]])
