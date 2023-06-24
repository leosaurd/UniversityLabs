#!/usr/bin/env python3
from ev3dev2.motor import LargeMotor, OUTPUT_B, OUTPUT_C, SpeedPercent, MoveTank
from ev3dev2.sensor.lego import ColorSensor, TouchSensor, UltrasonicSensor
from ev3dev2.sound import Sound
from time import sleep

mLeft = LargeMotor(OUTPUT_B)
mRight = LargeMotor(OUTPUT_C)
sound = Sound()
cs = ColorSensor()
us = UltrasonicSensor()
us.mode = 'US-DIST-CM'
units = us.units

while True:
    drive = MoveTank(OUTPUT_B, OUTPUT_C)
    distance = us.value()/10
    print(str(distance) + " " + units)

#while True:
#    drive.on(SpeedPercent(25), SpeedPercent(25))
#    if cs.color == 1:
#        break;

#test

sound = Sound()

sound.beep()
