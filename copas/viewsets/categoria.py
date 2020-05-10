from copas.models import Categoria
from copas.serializers.categoria import CategoriaSerializer
from rest_framework import viewsets


class CategoriaViewSet(viewsets.ModelViewSet):
    serializer_class = CategoriaSerializer
    queryset = Categoria.objects.all()