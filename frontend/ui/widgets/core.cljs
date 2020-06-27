(ns ui.widgets.core
  (:require [o2w.routes :as routes]
            ["@brainhubeu/react-carousel" :default Carousel]
            "@brainhubeu/react-carousel/lib/style.css"))

(defn seccion [{:keys [titulo c data]}]
  ^{:key titulo}
  [:div.seccion
   [:h1.titulo titulo]
   (doall (map c @data))])

(defn copa [{:keys [id nombre slug imagen] :as copa}]
  ^{:key id}
  [:div.col-4>div.card
   [:a {:href (routes/url :copas/detalle {:pk id :slug slug})}
    [:img {:src imagen}]
    [:h2 nombre]]])

(defn slider [copas]
  (js/console.log "slider" copas)
  [:div ;;{:style {:height "100%"}}
   [:> Carousel
    {:slidesPerPage 2
     :infinite true
     :keepDirectionWhenDragging true}
    (doall (map copa copas))]])