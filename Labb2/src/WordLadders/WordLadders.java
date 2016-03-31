package WordLadders;

import java.io.IOException;
import java.util.ArrayList;

public class WordLadders {
	// Vi behöver kanske en klass node och en klass edge för att hålla reda på skit, oklart.
	ArrayList<String> words;

	public WordLadders() {
		words = new ArrayList<String>();
	}

	public void readWordsFromFile(String path) throws IOException {
		Parser p = new Parser(path);
		words = p.Parse();
	}

	// TODO sätter in alla ord i den datastruktur vi vill ha, vilket förmodligen
	// är någon slags träd?
	public void wordTree() {

	}

	// Spelling, verkar funka, dock inte snyggt??
	public boolean isNeighbors(String s1, String s2) {
		String[] b = new String[4];
		String[] a = new String[5];
		for (int k = 0; k < 4; k++) {
			b[k] = s1.substring(k, k + 1);
		}
		for (int i = 0; i < 5; i++) {
			a[i] = s2.substring(i, i + 1);
		}
		int count = 0;
		for (String sa : a) {
			for (String sb : b) {
				if (sa.equals(sb)) {
					count++;
				}
			}
		}

		if (count >= 4) {
			return true;
		}
		return false;
	}

	// TODO
	public String findClosestPath(String s1, String s2) {
		return "";
	}

	// TODO
	public void findAllClosestPaths() {
		
	}

	public void addWordtoList(String s) {
		words.add(s);
	}
}
