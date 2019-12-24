import java.util.*; 
import java.nio.charset.StandardCharsets; 
import java.nio.file.*; 
import java.io.*; 


public class ReadWriteClass{
	private List<String> example;
	private String filename;
	public ReadWriteClass(){
		filename = "./alcoholMixer.txt";
		getAlcoholMixers();
	}

	public void writeAlcohol(String aName){
		List<String> tmp = example;
		try{
			// Assume default encoding.
            FileWriter fileWriter =
                new FileWriter(filename);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            Iterator<String> itr = tmp.iterator(); 
		    while (itr.hasNext()){
		    	//System.out.println(itr.next());
            	bufferedWriter.write(itr.next());
		  	  	bufferedWriter.newLine();
            }
            bufferedWriter.write(aName);
            bufferedWriter.newLine();
            getAlcoholMixers();
           // Always close files.
            bufferedWriter.close();
		} catch (IOException ex){
			System.out.println(
                "Error writing to file '"
                + filename + "'");
		}
	}

	public void getAlcoholMixers(){
		example = Collections.emptyList(); 
		try
	    { 
	      example = Files.readAllLines(Paths.get(filename), StandardCharsets.UTF_8); 
	    } 
	  
	    catch (IOException e) 
	    { 
	      e.printStackTrace(); 
	    }
	}
}