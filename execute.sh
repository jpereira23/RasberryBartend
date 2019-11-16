#!/bin/bash
 
 javac -classpath .:classes:/opt/pi4j/lib/'*' -d . Robot.java
 javac GUI.java
 if [ $? -eq 0 ]; then
   javac MainRobot.java
   if [ $? -eq 0 ]; then
     java -classpath .:classes:/opt/pi4j/lib/'*' MainRobot
   else
     echo Errors occured
   fi
 else
   echo Errors occured
 fi