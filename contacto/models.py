from django.db import models

# Create your models here.
class Contacto(models.Model):
    nombre = models.CharField(max_length=100)
    apellidos = models.CharField(max_length=100)
    email = models.EmailField()
    mensaje = models.TextField(null=True, blank=True)

    def __str__(self):
        return self.nombre