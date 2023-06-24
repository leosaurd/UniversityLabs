#!/usr/bin/env python3
from ev3dev2.motor import LargeMotor, OUTPUT_B, OUTPUT_C, SpeedPercent, MoveTank
from ev3dev2.sound import Sound
from ev3dev2.sensor.lego import ColorSensor, UltrasonicSensor, TouchSensor
from Goal_framework_test import GoalAgent
import time

mLeft = LargeMotor(OUTPUT_B)
mRight = LargeMotor(OUTPUT_C)
drive = MoveTank(OUTPUT_B, OUTPUT_C)
us = UltrasonicSensor()
cs = ColorSensor()
speaker = Sound()
ts = TouchSensor()
# global
turn_left_on_grey = False
ga = GoalAgent()
atTower = False
distance = []
move = 0
check = 0
flip = True


# the first turn to go towards the bottle
def turn_one(light1):
    global count
    print("s " + str(light1) + " " + str(count))  # print my info
    ga.var_forward(ga.turnPercentage * 0.45)
    drive.off()
    time.sleep(1)  # waits
    ga.right90()  # turn 90 degs to the right
    ga.var_backwards(0.45 - (ga.turnPercentage * 0.45))


# go forward, and check for tiles
# once at tile 55,70,85, and 100 it will move to forward into the grey tile
# and starts calling the find_bottle method. Stores the returned value from
# find_bottle method in "tile" variable and use it to check which tile the tower is located
def go(light1, flip1):
    global count
    global move
    global atTower

    print("e " + str(light1) + " " + str(count))

    # if we have changed from white to black increase and say count
    if flip1:
        count += 1

        if ga.vert:  # check if we are going vertically as count will need to be incremented by a larger amounts
            count += 14
        drive.off()
        ga.correction_sam_main(count)
        speaker.speak(str(count))
        time.sleep(1)
        drive.on(20, 20)

        if count == 55 or count == 70 or count == 85 or count == 100:
            tile = 0
            found = False
            drive.on_for_seconds(SpeedPercent(20), SpeedPercent(20), 2)
            drive.off()
            ga.left90()
            drive.off()
            time.sleep(1)
            tile += find_bottle()
            if tile == 0:
                speaker.speak("nothing here")
            else:
                if count == 55:
                    speaker.speak("tower at {}".format(str(tile)))
                    found = True
                elif count == 70:
                    if tile == 1:
                        speaker.speak("tower at {}".format(str(4)))
                        found = True
                    elif tile == 2:
                        speaker.speak("tower at {}".format(str(5)))
                        found = True
                    elif tile == 3:
                        speaker.speak("tower at {}".format(str(6)))
                        found = True
                elif count == 85:
                    if tile == 1:
                        speaker.speak("tower at {}".format(str(7)))
                        found = True
                    elif tile == 2:
                        speaker.speak("tower at {}".format(str(8)))
                        found = True
                    elif tile == 3:
                        speaker.speak("tower at {}".format(str(9)))
                        found = True
                elif count == 100:
                    if tile == 1:
                        speaker.speak("tower at {}".format(str(10)))
                        print(10)
                        found = True
                    elif tile == 2:
                        speaker.speak("tower at {}".format(str(11)))
                        print(11)
                        found = True
                    elif tile == 3:
                        speaker.speak("tower at {}".format(str(12)))
                        print(12)
                        found = True

            if found:
                time.sleep(100)
                quit()
            else:
                ga.right90()

    return not flip1


# method to search for the bottles
def bottle_search():
    goal = False
    while not goal:
        ga.left90()
        drive.on(SpeedPercent(20), SpeedPercent(20))  # go forward
        if (light < 15 and flip) or ((light > 45 and not flip) and not ga.vert) or ((light > 20 and not flip) and ga.vert):  # checking the the light level is below 15 and were on black or if light level is above 45 and we were on white
            flip = go(light, flip)


# method that stores the distance read by ultrasonic sensor into a variable "distance"
# variable "distance" is then compared to the distance of each tile from where the robot is
# a max of just 3 tiles where each grey tile is roughly 30cm wide.
# if distance falls between the distance the the location of the tile is stored in result and returned.
def find_bottle():
    result = 0
    local_distance = us.distance_centimeters
    if local_distance <= 32:
        result += 1
        print(count)
    elif 32 < local_distance <= 64:
        result += 2
        print(count)
    elif 64 < local_distance <= 100:
        result += 3
        print(count)
    else:
        result = 0

    return result


# move onto black from start
ga.var_forward(0.85)
ga.right90()

# main loop
index = 0  # counter keeps track of the number of times loops runs. Used to get average of cs.reflected_light_intensity
light = 0  # a var to store averages
count = 0
while True:
    """change gray correction back.s"""
    # update light
    index += 1
    light = cs.reflected_light_intensity
    if ts.is_pressed:  # stop if the touch sensor is pressed
        drive.off()
        break
    drive.on(SpeedPercent(20), SpeedPercent(20))  # go forwards

    if count == 10 and not ga.vert:  # check if we have moved 11 squares forward
        turn_one(light)
        ga.correction_sam_main(count)
    elif (light < 15 and flip) or ((light > 45 and not flip) and not ga.vert) or ((light > 20 and not flip) and ga.vert):
        # checking the the light level is below 15 and were on black or if light level is above 45 and we were on white
        flip = go(light, flip)





