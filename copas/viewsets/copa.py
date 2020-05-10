from copas.models import Copa
from copas.serializers.copa import CopaSerializer
from rest_framework import viewsets


class CopaViewSet(viewsets.ModelViewSet):
    serializer_class = CopaSerializer

    def get_queryset(self):
        """
        This view should return a list of all the purchases for
        the user as determined by the username portion of the URL.
        """
        categoria = self.request.query_params.get('categoria')
        if categoria:
            return Copa.objects.filter(categoria=categoria)
        return Copa.objects.all()