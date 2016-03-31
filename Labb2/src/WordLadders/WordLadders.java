package WordLadders;

import java.io.IOException;
import java.util.ArrayList;

public class WordLadders {
	
	ArrayList<String> words;
	public WordLadders(){
		words = new ArrayList<String>();
	}
	
	public void readWordsFromFile(String path) throws IOException{
		Parser p = new Parser(path);
		words = p.Parse();
	}
}

