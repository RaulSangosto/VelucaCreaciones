(ns ui.widgets.core
  (:require [o2w.routes :as routes]
            [o2w.forms.core :as forms]
            [reagent.core :as r]
            ; ["@brainhubeu/react-carousel" :default Carousel]
            ; "@brainhubeu/react-carousel/lib/style.css"
            ))

(defn seccion [{:keys [titulo c data]}]
  ^{:key titulo}
  [:div.seccion
   [:h1.titulo titulo]
   [:div.container-fluid.grid-container
    [:div.row
    (doall (map c @data))]]])

(defn copa [{:keys [id nombre slug imagen] :as copa}]
  ^{:key id}
  [:div.col-md-4 {:style {:margin-bottom "3vw" :margin-top "3vw"}} 
   [:div.card {:style {:padding "5px" :max-width "500px"}}
   [:a {:href (routes/url :copas/detalle {:pk id :slug slug})}
    [:div.foto
     [:img {:src imagen}]
     [:h2.titulo nombre]]
    [:div ]]]])

(defn contactar-formulario [{:keys [titulo]}]
  (r/with-let [f (forms/new-form {})
               enviado? (r/atom false)]
  ^{:key titulo}
  [:div.seccion
   [:h1.titulo titulo]
   [:div.container-fluid.grid-container
    [:div.card
     (if @enviado?
       [:p#success.success.alert.alert-success "Muchas gracias por contactar con nosotros"]

       [:form.contact_form {:on-submit (forms/on-submit f {:endpoint "pedido"
                                                             :ok       #(reset! enviado? true)})}
        [:div.row
         [:div.col-lg-12
          [f :nombre {:name "firstname" :placeholder "Nombre*"}]]
         [:div.col-lg-12
          [f :apellidos {:name "lastname" :placeholder "Apellidos*"}]]
         [:div.col-lg-12
          [f :email {:name "email" :placeholder "Email*"}]]

         [:div.col-lg-12.text-center
          [:button#submit_3
           {:type     "submit"}
           "CONTACTAR AHORA"]]]])]]]))

(defn slider [copas]
  (js/console.log "slider" copas)
  [:div ;;{:style {:height "100%"}}
  ;  [:> Carousel
  ;   {:slidesPerPage 2
  ;    :infinite true
  ;    :keepDirectionWhenDragging true}
  ;   (doall (map copa copas))]
   ])