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

    def __init__(self):
        """Initiating method that sets starting position and angle."""
        self.xy = [0, 100]
        self.angle = 90
        self.current_square = None
        self.vert = True
        self.correction_flip = True
        self.max1 = 0
        self.max2 = 0
        self.value_difference = 10
        self.value_diff_max = 2.7/2
        self.value_diff_min = -2.7/2
        self.turnPercentage = 0

    def right90(self):
        self.vert = not self.vert
        drive.on_for_rotations(13, -13, 0.95/2)
        return

    def left90(self):
        self.vert = not self.vert
        drive.on_for_rotations(-13, 13, 0.95 / 2)
        return
    
    @staticmethod
    def straight_horizontal_one_tile():
        drive.on_for_rotations(20, 20, 1.18)
        
    @staticmethod
    def straight_vertical_one_tile():
        drive.on_for_rotations(20, 19, 0.975)
    
    @staticmethod
    def var_forward(value):
        drive.on_for_rotations(20, 20, value)

    @staticmethod
    def var_backwards(value):
        drive.on_for_rotations(-20, -20, value)

    def correction_test(self):
        self.var_forward(0.05)
        start_time = time.time()
        while True:
            # move left(because right wheel is turned on)
            mRight.on(SpeedPercent(20))
            # if light reflected is not blacks
            if cs.reflected_light_intensity > 20:
                # record the time
                end_time = time.time()
                # save it into a value
                value = end_time - start_time
                # stop the motors
                drive.off()
                time.sleep(0.1)
                # break out of the surrounding while loop
                break
        # return back to normal position
        mRight.on_for_seconds(SpeedPercent(-20), value)
        # repeat the above for the right
        start_time = time.time()
        while True:
            mLeft.on(SpeedPercent(20))
            if cs.reflected_light_intensity > 20:
                end_time = time.time()
                value2 = end_time - start_time
                drive.off()
                time.sleep(0.1)
                break
        mLeft.on_for_seconds(SpeedPercent(-20), value2)
        # if either max1 or max2 has not yet been set, use the current two as the first values and proceed
        if self.max1 == 0 or self.max2 == 0:
            self.max1 = value
            self.max2 = value2
            self.value_difference = abs(value - value2)
            return
        # one of these will evaluate to a positive, and the other to a negative. 
        # We want to turn in the direction of the positive, based on the difference between previous & current value.
        move_dist2 = (value2 - self.max2) * 0.5  # multiplied by a small coefficient of 0.5 to make it turn half.
        move_dist = (value - self.max1) * 0.5

        if (value2 - self.max2) > 0:
            mLeft.on_for_seconds(SpeedPercent(20), move_dist2)
        elif (value - self.max1) > 0:
            mRight.on_for_seconds(SpeedPercent(20), move_dist)

        # To set a max value based on diff, to tell it how far forward to go.
        # This code will set new "max difference" values between the two circles.
        if value2 > value and value2 > self.value_diff_max:
            self.value_diff_max = value2
        elif value > value2 and value > self.value_diff_max:
            self.value_diff_max = value
            # as minimum is always negative, we can just directly add it.
        self.turnPercentage = ((value2-value) - self.value_diff_min) / (self.value_diff_max - self.value_diff_min)

        # if value difference is bigger than the new value difference, set params to the new values.
        if self.value_difference > abs(value-value2):
            self.max1 = value
            self.max2 = value2
            self.value_difference = abs(value-value2)

    def correction(self):
        coefficient = 0.8
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

        circle_1 = self.time_to_rads(value)
        circle_2 = self.time_to_rads(value2)

        circle_3 = abs((circle_1 - circle_2)/2)

        circle_4 = math.atan(circle_3)
        circle_5 = self.rad_to_deg(circle_4)
        #    circle_5 *= 0.5ss
        if circle_1 > circle_2:
            drive.on_for_degrees(-20, 20, circle_5 * coefficient)
        elif circle_2 > circle_1:
            drive.on_for_degrees(20, -20, circle_5 * coefficient)

    @staticmethod
    def rad_to_deg(rad):
        rad *= 180/math.pi
        return rad

    @staticmethod
    def time_to_rads(localtime):  # changed this to prevent shadowing time variable.
        return localtime/2.71139001846

    def taya_correction(self, c_value, direction=1):
        while cs.reflected_light_intensity < 15:
            drive.on(20, 20)
        drive.off()
        drive.on_for_rotations(20, 20, 1.85)
        while True:
            if cs.reflected_light_intensity < 15:
                drive.on_for_rotations(-20, -20, -1.7)
                break
            else:
                drive.off()
                drive.on_for_rotations(-20, -20, 1.85)
                if direction == 1:
                    drive.on_for_degrees(20, -20, c_value)
                    self.taya_correction(c_value + 5, direction=0)
                    break
                else:
                    drive.on_for_degrees(-20, 20, c_value)
                    self.taya_correction(c_value + 5, direction=1)
                    break







