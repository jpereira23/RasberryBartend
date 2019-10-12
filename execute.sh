#!/bin/bash

javac -classpath .:classes:/opt/pi4j/lib/'*' -d . MainRobot.java

if [ $? -eq 0 ]; then
  java -classpath .:classes:/opt/pi4j/lib/'*' MainRobot
else
  echo Errors occured
fi
