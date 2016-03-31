package WordLadders;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		WordLadders wl = new WordLadders();
		// wl.readWordsFromFile("noInternets.txt");
		wl.findAllClosestPaths();
		wl.addWordtoList("where");
		wl.addWordtoList("there");
		boolean result;
		result = wl.isNeighbors("whrrr","there");
		System.out.print(result);
	}
}
