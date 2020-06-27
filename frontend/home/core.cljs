(ns home.core
  (:require [o2w.api.core :as api]
            [reagent.core :as r]
            [app.db :as db]
            [ui.widgets.core :as w]))

(defonce ultimas-copas (r/atom nil))
(defonce opiniones (r/atom nil))

(api/get "copas/latest" {:ok #(reset! ultimas-copas %)})

(defn page []
  [:<>
   [:div.title
    [:h1.t (:titulo @db/cabecera)]
    [:h1.subt (:subtitulo @db/cabecera)]]
   [w/slider @ultimas-copas]
   [w/seccion {:titulo "Nuestros últimos encargos"
             :c      w/copa
             :data   ultimas-copas}]
  ;;  [w/seccion {:titulo "Lo que opinan nuestros clientes"
  ;;              :c      w/copa
  ;;              :data   opiniones}]
   ])