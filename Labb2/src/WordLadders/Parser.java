package WordLadders;

import java.io.*;
import java.util.ArrayList;

public class Parser {
	String path;
	public Parser(String path){
		this.path = path;
	}
	// String är placehold för test, oklart om den ska returna String.
	public ArrayList<String> Parse() throws IOException{
		ArrayList wordList = new ArrayList<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str;
			while((str = br.readLine()) != null){
				wordList.add(str);
				System.out.println("Testprint" + str);
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("Filen hittades inte.");
			e.printStackTrace();
		}
		return wordList;
		
		
	}
}
