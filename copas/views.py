from django.shortcuts import render

# Create your views here.
from django.core.mail import send_mail
from django.shortcuts import render
from django.views.generic import TemplateView


class HomeView(TemplateView):
    template_name = "frontend.html"


home = HomeView.as_view()