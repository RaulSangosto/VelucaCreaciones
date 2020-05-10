(ns ui.menu
  (:require [o2w.routes :as routes]
            [o2w.api.core :as api]
            [app.db :as db]))

(api/get "categorias" {:ok #(reset! db/categorias %)})

(defn active [key]
    (when (= (:name @routes/current-route) key) {:class "selected"}))

(defn submenu-item [{:keys [nombre id slug] :as categoria}]
  ^{:key id}
  [:<>
   (js/console.log categoria)
   [:li.submenu-item
    [:a {:href (routes/url :stock/categoria {:pk id :slug slug})} nombre]]])

(defn default []
  [:<>
   [:ul.menu
    [:li.item (active :conocenos) [:a {:href (routes/url :conocenos)} "Conócenos"]]
    [:li.item.desplegable (active :stock) [:a {:href (routes/url :stock)} "Stock"]
     (when @db/categorias [:ul.submenu (doall (map submenu-item @db/categorias))])]
    [:li.item (active :ultimos-encargos) [:a {:href (routes/url :ultimos-encargos)} "Últimos encargos"]]
    [:li.item (active :personaliza-tu-copa) [:a {:href (routes/url :personaliza-tu-copa)} "Personaliza tu copa"]]
    [:li.item (active :contactar) [:a {:href (routes/url :contactar)} "Contactar"]]]])
