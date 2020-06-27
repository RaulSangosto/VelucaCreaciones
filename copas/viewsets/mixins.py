from rest_framework.decorators import action
from rest_framework.response import Response


class LatestMixin:
    @action(detail=False)
    def latest(self, request):
        qs = super().get_queryset()
        qs = qs.order_by("-id")[:5]
        serializer = self.get_serializer(qs, many=True)
        return Response(serializer.data)