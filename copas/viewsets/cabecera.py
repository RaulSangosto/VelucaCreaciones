from copas.models import Cabecera
from copas.serializers.cabecera import CabeceraSerializer
from rest_framework import viewsets


class CabeceraViewSet(viewsets.ModelViewSet):
    serializer_class = CabeceraSerializer
    queryset = Cabecera.objects.all()