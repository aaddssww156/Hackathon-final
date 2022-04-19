# Generated by Django 4.0.3 on 2022-04-19 06:53

from django.db import migrations, models


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Rooms',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('address', models.CharField(max_length=120)),
                ('capacity', models.IntegerField()),
                ('isempty', models.BooleanField()),
            ],
        ),
    ]
