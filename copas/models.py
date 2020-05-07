from django.db import models

# Create your models here.
class Copa(models.Model):
    nombre = models.CharField(null=True, blank=True, max_length=100)
    descripcion = models.TextField(null=True, blank=True)
    imagen = models.ImageField(null=True, blank=True,upload_to="imagenes")
    precio = models.CharField(null=True, blank=True, max_length=6)

    def __str__(self):
        return self.nombre