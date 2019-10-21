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
      int responseCode = con.getResponseCode();
      System.out.println(responseCode);
    } catch (IOException e){
      System.out.println("Hello, world");
    }
  }
}
