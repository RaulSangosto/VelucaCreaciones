from django.db import models

# Create your models here.
class Copa(models.Model):
    nombre = models.CharField(null=True, blank=True, max_length=100)
    descripcion = models.TextField(null=True, blank=True)
    imagen = models.ImageField(null=True, blank=True,upload_to="imagenes/copas")
    precio = models.CharField(null=True, blank=True, max_length=6)
    categoria = models.ForeignKey("Categoria", on_delete=models.CASCADE, blank=True, null=True)
    slug = models.SlugField(max_length=100)

    def __str__(self):
        return self.nombre


class Categoria(models.Model):
    nombre = models.CharField(null=True, blank=True, max_length=100)
    imagen = models.ImageField(null=True, blank=True,upload_to="imagenes/categorias")
    overlay = models.BooleanField(default=False)
    slug = models.SlugField(max_length=100)

    def __str__(self):
        return self.nombre


class Cabecera(models.Model):
    nombre = models.CharField(null=True, blank=True, max_length=100)
    titulo = models.CharField(null=True, blank=True, max_length=200)
    subtitulo = models.CharField(null=True, blank=True, max_length=200)
    slug = models.SlugField(max_length=100)
    imagen = models.ImageField(null=True, blank=True,upload_to="imagenes/categorias")
    overlay = models.BooleanField(default=False)

    def __str__(self):
        return self.nombre