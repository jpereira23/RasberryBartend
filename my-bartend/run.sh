#!/bin/bash
mvn exec:java -Dpi4j.linking=dynamic -classpath .:classes:/opt/pi4j/lib/'*' -Dexec.mainClass="com.bartend.app.Main"
