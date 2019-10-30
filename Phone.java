import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;

public class Phone{

	public static void main(String[] args){
		JSONObject object = new JSONObject();
		object.put("drinkName", "Luke");
		object.put("slot1", "1");
		object.put("slot2", "2");
		object.put("slot3", "3");
		object.put("slot4", "4");
		object.put("slot5", "5");
		object.put("slot6", "6");
		object.put("slot7", "7");
		object.put("slot8", "8");
		object.put("slot9", "9");
		object.put("slot10", "10");
		object.put("slot11", "11");
		object.put("slot12", "12");
		object.put("slot13", "13");
		object.put("slot14", "14");
		object.put("slot15", "15");

		try {
			Socket socket = new Socket("138.197.205.247", 8080);
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(object.toString());

			bw.flush();
		} catch (IOException err){
			System.out.println("Something is up");
		}
	}
}
