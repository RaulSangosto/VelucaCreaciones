from copas.models import Copa
from copas.serializers.copa import CopaSerializer
from rest_framework import viewsets
from .mixins import LatestMixin


class CopaViewSet(LatestMixin, viewsets.ModelViewSet):
    serializer_class = CopaSerializer
    queryset = Copa.objects.all()

    def get_queryset(self):
        categoria = self.request.query_params.get('categoria')
        if categoria and categoria != 'null':
            return Copa.objects.filter(categoria=categoria)
        return Copa.objects.all()

        