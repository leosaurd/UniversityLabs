#!/usr/bin/env python3
from ev3dev2.motor import LargeMotor, OUTPUT_B, OUTPUT_C, SpeedPercent, MoveTank
from ev3dev2.sensor.lego import ColorSensor
import time
import math

mLeft = LargeMotor(OUTPUT_B)
mRight = LargeMotor(OUTPUT_C)
drive = MoveTank(OUTPUT_B, OUTPUT_C)
cs = ColorSensor()


class GoalAgent:
    """The class for all goal agent methods and attributes."""

    def __init__(self):
        """Initiating method that sets starting position and angle."""
        self.xy = [0, 100]
        self.angle = 90
        self.current_square = None
        self.vert = True
        self.correction_filp = True
        self.max1 = 2
        self.max2 = 2

    def right90(self):
        self.vert = not self.vert
        drive.on_for_rotations(13, -13, 0.95/2)
        self.max1 = 2
        self.max2 = 2
        return

    def straight_backward(self,rots):
        drive.on_for_rotations(-10,-10,rots)

    def left90(self):
        self.vert = not self.vert
        drive.on_for_rotations(-13, 13, 0.95 / 2)
        return

        return
    def straight_horizontal_one_tile(self):
        drive.on_for_rotations(20,20,1.18)
    def straight_vertical_one_tile(self):
        drive.on_for_rotations(20,19,0.975)
    def var_forward(self, value):
        drive.on_for_rotations(20,20,value)

    def var_backwards(self, value):
        drive.on_for_rotations(-20,-20,value)

    """method to keep the robot straighssssssssssssss
    ss"""
    def correction(self, value, count):
        speed = 13
        if count != 1 :
            #drive.on_for_rotations(20, 20, 0.3)
            time.sleep(0.1)
            drive.on_for_degrees(speed, -speed, value)
            time.sleep(0.1)
            while cs.reflected_light_intensity > 10:
                drive.on(-speed, speed)
            drive.off()
            time.sleep(0.1)
            drive.on_for_degrees(-speed, speed, 2 * value)
            time.sleep(0.1)
            while cs.reflected_light_intensity > 10:
                drive.on(speed, -speed)
            drive.off()
            time.sleep(0.1)
            drive.on_for_degrees(speed, -speed, value)
            time.sleep(0.1)

    def correction_sam_main(self, coef):
        coef = 0.8
        start_time = time.time()
        while True:
            # move left(because right wheel is turned on)sss
            mRight.on(SpeedPercent(20))
            # if light reflected is not black
            if cs.reflected_light_intensity > 20:
                # record the time
                end_time = time.time()
                # save it into a value
                value = end_time - start_time
                # stop the motors
                drive.off()
                # break out of the surrounding while loop
                break
        # return back to normal position
        mRight.on_for_seconds(SpeedPercent(-20), value)
        # repeat the above for the right(left wheel now turned on)sssssssa
        start_time = time.time()
        while True:
            mLeft.on(SpeedPercent(20))
            if cs.reflected_light_intensity > 20:
                end_time = time.time()
                value2 = end_time - start_time
                drive.off()
                break
        mLeft.on_for_seconds(SpeedPercent(-20), value2)

        cirle_1 = self.time_to_rads(value)
        cirle_2 = self.time_to_rads(value2)

        cirle_3 = abs((cirle_1 - cirle_2)/2)

        cirle_4 = math.atan(cirle_3)
        cirle_5 = self.rad_to_deg(cirle_4)
        #max = 90
        #if cirle_5 > max :s
        #    cirle_5 *= 0.5
        if cirle_1 > cirle_2:
            drive.on_for_degrees(-20, 20, cirle_5 * coef)
        elif cirle_2 > cirle_1:
            drive.on_for_degrees(20, -20, cirle_5 * coef)


    def rad_to_deg(self,rad):
        rad *= 180/math.pi
        return rad

    def time_to_rads(self,time):
        return time/2.71139001846








