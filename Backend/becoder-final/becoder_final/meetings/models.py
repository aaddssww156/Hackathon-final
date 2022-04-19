from django.db import models
from rooms.models import Rooms
from django.contrib.auth.models import User
# Create your models here.
class Meetings(models.Model):
    room_id = models.ForeignKey(Rooms, on_delete=models.CASCADE)
    user_id = models.ForeignKey(User, on_delete=models.CASCADE)
    meetday = models.DateField()
    meetstart = models.TimeField()
    meetend = models.TimeField()
    info = models.TextField()