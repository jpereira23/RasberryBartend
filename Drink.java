import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class Drink{
	private String drinkName; 
	private int slotArray[];

	public Drink(JSONObject object){
		slotArray = new int[15];
		drinkName = object.get("drinkName").toString();
		slotArray[0] = Integer.parseInt(object.get("slot1").toString());
		slotArray[1] = Integer.parseInt(object.get("slot2").toString());
		slotArray[2] = Integer.parseInt(object.get("slot3").toString());
		slotArray[3] = Integer.parseInt(object.get("slot4").toString());
		slotArray[4] = Integer.parseInt(object.get("slot5").toString());
		slotArray[5] = Integer.parseInt(object.get("slot6").toString());
		slotArray[6] = Integer.parseInt(object.get("slot7").toString());
		slotArray[7] = Integer.parseInt(object.get("slot8").toString());
		slotArray[8] = Integer.parseInt(object.get("slot9").toString());
		slotArray[9] = Integer.parseInt(object.get("slot10").toString());
		slotArray[10] = Integer.parseInt(object.get("slot11").toString());
		slotArray[11] = Integer.parseInt(object.get("slot12").toString());
		slotArray[12] = Integer.parseInt(object.get("slot13").toString());
		slotArray[13] = Integer.parseInt(object.get("slot14").toString());
		slotArray[14] = Integer.parseInt(object.get("slot15").toString());
	}

	public Object[] getObject(){
		Object objArray[] = new Object[16];

		objArray[0] = drinkName;
		for (int i = 1; i < 16; i++){
			objArray[i] = slotArray[i-1];	
		}

		return objArray;
	}

	public Int[] getSlots(){
		return slotArray;
	}
}
