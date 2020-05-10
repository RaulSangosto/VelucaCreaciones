(ns ui.widgets.core
  (:require [o2w.routes :as routes]))

(defn seccion [{:keys [titulo c data]}]
  ^{:key titulo}
  [:div.seccion
   [:h1.titulo titulo]
   (doall (map c @data))])

(defn copa [{:keys [id nombre imagen]}]
  ^{:key id}
  [:div.col-4>div.card
   [:a {:href (routes/url :albumes/detalle {:pk id})}
    [:img {:src imagen}]
    [:h2 nombre]]])