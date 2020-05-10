(ns home.core
  (:require [o2w.api.core :as api]
            [reagent.core :as r]
            [app.db :as db]
            [ui.widgets.core :as w]))

(defonce copas (r/atom nil))

(api/get "copas" {:ok #(reset! copas %)})

;; (defn cabecera-fondo []
;;    [:div.cabecera-fondo
;;    [:div.row.full
;;     [:div.col-md-9.full
;;     [:img {:src "/static/img/fondo.png"}]]
;;    [:div.col-md-3.full.magenta-bg]]])

;; (defn seccion [{:keys [titulo c data]}]
;;   ^{:key titulo}
;;   [:div.seccion
;;    [:h1.titulo titulo]
;;    (doall (map c @data))])

(defn page []
  [:<>
  ;;  [cabecera-fondo]
    [:div.title
     [:h1.t (:titulo @db/cabecera)]
     [:h1.subt (:subtitulo @db/cabecera)]]
   [w/seccion {:titulo "Nuestros últimos encargos"
             :c      w/copa
             :data   copas}]
   [w/seccion {:titulo "Lo que opinan nuestros clientes"
               :c      w/copa
               :data   copas}]])