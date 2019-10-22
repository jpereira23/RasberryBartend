import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;

public class API{
  private String url;
  URL obj;
  HttpURLConnection con;
  public API(){
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
      try{
        while((inputLine = in.readLine()) != null){
          JSONObject json = new JSONObject(inputLine); 
          System.out.println(json.get("drinkName"));

        }
      } catch (JSONException ex){
        System.out.println("Nope");
      }
            in.close();
    } catch (IOException e){
      System.out.println("Hello, world");
    }
  }

  
}
