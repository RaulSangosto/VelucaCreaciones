from django.contrib import admin
from .models import Copa, Categoria, Cabecera


class CopaAdmin(admin.ModelAdmin):
    prepopulated_fields = {"slug": ("nombre",)}


class CabeceraAdmin(admin.ModelAdmin):
    prepopulated_fields = {"slug": ("nombre",)}


class CategoriaAdmin(admin.ModelAdmin):
    prepopulated_fields = {"slug": ("nombre",)}


# Register your models here.
admin.site.register(Copa, CopaAdmin)
admin.site.register(Categoria, CategoriaAdmin)
admin.site.register(Cabecera, CabeceraAdmin)