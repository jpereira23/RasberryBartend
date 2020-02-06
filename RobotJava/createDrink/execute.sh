#!/bin/bash

javac Main.java AdminWizard/AdminWizard.java AlcoholMixer/AlcoholMixerCreate.java AlcoholMixerPage/AlcoholMixerPage.java GUIManager.java MainPage/MainPage.java dictateSlots/DictateSlotsPage.java helper/BartendPanel.java PleaseSelectDrinkPage/PleaseSelectDrinkPage.java createDrink/CreateDrinkPage.java -d .


if [ $? -eq 0 ]; then
		java Main
fi 

