(ns app.routes
  (:require home.core
            copas.core
            copas.detalle
            copas.ultimas
            copas.personalizar.core
            conocenos.core
            contactar.core))

(def views {:home                #'home.core/page
            :conocenos           #'conocenos.core/page
            :stock               #'copas.core/page
            :stock/categoria     #'copas.core/page
            :copas/detalle       #'copas.detalle/page
            :ultimos-encargos    #'copas.ultimas/page
            :personaliza-tu-copa #'copas.personalizar.core/page
            :contactar           #'contactar.core/page})
(def routes
  [["/"                  :home]
   ["/conocenos"         :conocenos]
   ["/copas"             :stock]
   ["/copas/:pk/:slug"   :stock/categoria]
   ["/copa/:pk/:slug"    :copas/detalle]
   ["/ultimas-copas"     :ultimos-encargos]
   ["/personalizar-copa" :personaliza-tu-copa]
   ["/contactar"         :contactar]])
