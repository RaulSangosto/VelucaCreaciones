(ns contactar.core
  (:require [reagent.core :as r]
            [ui.widgets.core :as w]
            [o2w.api.core :as api]
            [app.db :as db]
            [o2w.forms.core :as forms]
            [clojure.set :as set]))

(defonce copas (r/atom nil))

(defn page []
  [:div
    [:div.title
     [:h1.t (:titulo @db/cabecera)]
     [:h1.subt (:subtitulo @db/cabecera)]]
[w/contactar-formulario {:titulo "¿Tienes alguna pregunta?"}]])
