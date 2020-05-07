from rest_framework import serializers
from copas.models import Copa

class CopaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Copa
        fields = '__all__'