import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;


public class API{
  private String url;
  URL obj;
  HttpURLConnection con;
  public Drink drink1;
  public API(GUI g){
    url = "http://138.197.205.247:8080/api/drinks";
    System.out.println("Jeffs world");
    try {
      obj = new URL(url);
      con = (HttpURLConnection) obj.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("Content-Type", "application/json");
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer content = new StringBuffer(); 
      inputLine= in.readLine();
      JSONObject json = new JSONObject(inputLine); 
      JSONArray arr = json.getJSONArray("message");
      drink1 = new Drink(arr.getJSONObject(0).getString("drinkName"), arr.getJSONObject(0).getInt("slot1"), arr.getJSONObject(0).getInt("slot2"), arr.getJSONObject(0).getInt("slot3"), arr.getJSONObject(0).getInt("slot4"), arr.getJSONObject(0).getInt("slot5"), arr.getJSONObject(0).getInt("slot6"), arr.getJSONObject(0).getInt("slot7"), arr.getJSONObject(0).getInt("slot8"), arr.getJSONObject(0).getInt("slot9"), arr.getJSONObject(0).getInt("slot10"), arr.getJSONObject(0).getInt("slot11"), arr.getJSONObject(0).getInt("slot12"), arr.getJSONObject(0).getInt("slot13"), arr.getJSONObject(0).getInt("slot14"), arr.getJSONObject(0).getInt("slot15")); 
      g.addData(drink1);
      in.close();
    } catch (IOException e){
      System.out.println("Hello, world");
    }
  }

  
}
