from django.shortcuts import render
from rest_framework import mixins, viewsets
from .models import Rooms
from .serializers import RoomSerializer
# Create your views here.
class RoomsViewSet(viewsets.GenericViewSet, mixins.ListModelMixin):
    queryset = Rooms.objects.all()
    serializer_class = RoomSerializer