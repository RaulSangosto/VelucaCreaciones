(ns ui.header
  (:require ui.menu
            [reagent.core :as r]
            [app.db :as db]
            [o2w.routes :as routes]
            [o2w.api.core :as api]))

(defonce cabeceras (r/atom nil))
(defonce categoria (r/atom nil))

(api/get "cabeceras" {:ok #(reset! cabeceras %)})
(api/get "categorias" {:ok #(reset! db/categorias %)})

(defn get-categoria [c]
  (when (= (str (:id c)) (get-in @routes/current-route [:params :pk]))
    (reset! categoria c)))

(defn get-cabecera [c]
  (when (= (:name @routes/current-route) (keyword (:slug c)))
    (reset! db/cabecera c))
  (when (= (:name @routes/current-route) :stock/categoria)
    ;;(js/console.log @db/categorias)
    (doall (map get-categoria @db/categorias))
    ;;(js/console.log @categoria)
    (reset! db/cabecera {:imagen (:imagen @categoria)
                         :titulo "Copas de"
                         :subtitulo (str (:nombre @categoria) ".")})))

(defn cabecera-fondo []
  (r/with-let [_cabecera (r/atom nil)]
      (doall (map get-cabecera @cabeceras))
    (when @db/cabecera
      [:div.cabecera-fondo
       [:div.row.full
        [:div.col-md-9.full
         [:img {:src (:imagen @db/cabecera)}]]
        [:div.col-md-3.full.magenta-bg
         [:p.texto "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed consectetur molestie elementum. Mauris sit amet laoreet tortor, ut pellentesque urna. Aenean et lobortis sem. Curabitur rutrum commodo aliquam. Fusce at aliquam erat. Nullam at ex eu metus consequat sodales."]]]])))

(defn default []
  [:<>
   [:header.top-bar
   [:div.row
    [:div.col-md-9
     [:div.row
    [:div.col-md-5
     [:a.logo {:href "/"} "velucacreaciones"]]
    [:div.col-md-7
     [ui.menu/default]
     ]]][:div.col-md-3]]]
   [cabecera-fondo]])