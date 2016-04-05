package WordLadders;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		WordLadders wl = new WordLadders();
		// wl.readWordsFromFile("noInternets.txt");
		boolean result;
		result = wl.isNeighbors("where","there");
		System.out.print(result +"\n");
		wl.words.put("where", new Word("where"));
		wl.makeNeighborFinder();
		Word w = new Word("where");
		System.out.println(w.getLastFour());
	}
}
