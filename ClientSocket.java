import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import java.io.IOException;



public class ClientSocket{
	private Socket clientSocket;
	private PrintWriter out;
	private BufferedReader in;
  public ClientSocketDelegate delegate;
  public ClientSocket(){

  }

  public void startConnection(){
  	try {
        
			clientSocket = new Socket("138.197.205.247", 8080);
      InputStreamReader streamReader= new InputStreamReader(clientSocket.getInputStream());
      BufferedReader reader= new BufferedReader(streamReader);
      OutputStream os = clientSocket.getOutputStream();
      OutputStreamWriter osw = new OutputStreamWriter(os);
      BufferedWriter bw = new BufferedWriter(osw);
      bw.write("robot");
      bw.flush();
      
      int c;
      String aReader = "";
      while((aReader = reader.readLine()) != null){
        try {
          JSONObject object = new JSONObject(aReader);
          System.out.println(object.toString());
          delegate.dataReceived(object);
        } catch (JSONException err){

        }
      }
      

      reader.close();
		} catch (IOException e){
			System.out.println("Hello World");
		}
	} 

	public void stopConnection(){

	}

	public void print(){
  	System.out.println("Fuck you");
	}
}
