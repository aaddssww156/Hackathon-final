from django.db import models

# Create your models here.
class Rooms(models.Model):
    """
    model for rooms
    """
    address = models.CharField(max_length=120)
    capacity = models.IntegerField()
    isempty = models.BooleanField()
    
    def __str__(self)->str:
        return self.address