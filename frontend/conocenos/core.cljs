(ns conocenos.core
  (:require [ui.widgets.core :as w]
            [reagent.core :as r]
            [app.db :as db]))

(defonce copas (r/atom nil))

(defn page []
  [:div
   [:div.title
    [:h1.t (:titulo @db/cabecera)]
    [:h1.subt (:subtitulo @db/cabecera)]]
   [w/seccion {:titulo "¿Quienes Somos?"
               :c      w/copa
               :data   copas}]])
