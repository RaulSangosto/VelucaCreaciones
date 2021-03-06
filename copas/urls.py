from django.conf.urls import include, url
from django.conf.urls.static import static
from django.contrib import admin
from django.contrib.staticfiles.urls import staticfiles_urlpatterns
from django.urls import path

from copas.viewsets.copa import CopaViewSet
from copas.viewsets.cabecera import CabeceraViewSet
from copas.viewsets.categoria import CategoriaViewSet
from rest_framework import routers

from . import views

router = routers.DefaultRouter(trailing_slash=False)
router.register('copas', CopaViewSet, basename='Copas')
router.register('cabeceras', CabeceraViewSet, basename='Cabeceras')
router.register('categorias', CategoriaViewSet, basename='Categorias')
router.register('contacto', ContactoViewSet, basename='Contacto')

urlpatterns = [
    url(r'^api/v1/', include(router.urls)),
]
