package WordLadders;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException{
		WordLadders wl = new WordLadders();
		// wl.readWordsFromFile("noInternets.txt");
		boolean result;
		result = wl.isNeighbors("where","there");
		System.out.print(result +"\n");
		wl.words.put("whera", new Word("whera"));
		wl.makeNeighborFinder();
		Word w = new Word("thare");
		System.out.println(w.getLastFour());
	}
}
