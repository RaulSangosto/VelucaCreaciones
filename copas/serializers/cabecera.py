from rest_framework import serializers
from copas.models import Cabecera

class CabeceraSerializer(serializers.ModelSerializer):
    class Meta:
        model = Cabecera
        fields = '__all__'