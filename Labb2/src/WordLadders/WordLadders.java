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
	
	/**
	 * Determines if there is an edge between s1 and s2 using ' ' and '\' as protected characters.
	 * @param s2
	 * @param s1 
	 * @return true if edge, otherwise false
	 */
	public boolean isNeighbors(String s1, String s2) {
		char[] a = s1.substring(1, s2.length()).toCharArray();
		char[] b = s2.toCharArray();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.println(a[i] + "// " +b[j]);
				if (a[i] == b[j]) {
					b[j] = ' ';
					a[i] = '\\';
					//TODO: Fix solid null-objects here.
					count++;
					continue;
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
