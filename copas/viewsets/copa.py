from copas.models import Copa
from copas.serializers.copa import CopaSerializer
from rest_framework import viewsets


class CopaViewSet(viewsets.ModelViewSet):
    serializer_class = CopaSerializer
    queryset = Copa.objects.all()