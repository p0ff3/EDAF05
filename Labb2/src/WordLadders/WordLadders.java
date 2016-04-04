package WordLadders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WordLadders {
	// Vi behöver kanske en klass node och en klass edge för att hålla reda på skit, oklart.
	HashMap<String, Word> words;

	public WordLadders() {
		words = new HashMap<String, Word>();
	}

	public void readWordsFromFile(String path) throws IOException {
		Parser p = new Parser(path);
		words = p.Parse();
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
				if (a[i] == b[j]) {
					b[j] = ' ';
					a[i] = '\\';
					//TODO: Fix solid null-objects here. Use '\0'?
					count++;
				}
			}
		}

		if (count >= 4) {
			return true;
		}
		return false;
	}

	public int findClosestPath(String start, String goal) {
		LinkedList<Word> Queue= new LinkedList<Word>();
		Word currentWord = words.get(start);
		currentWord.setDepth(0);
		Word goalWord = currentWord;
		Queue.add(currentWord);
		while(!Queue.isEmpty()){
			if(currentWord.isChecked()){
				currentWord = Queue.poll();
				continue;
			}
			ArrayList<Word>children = currentWord.getNeighbours();
			for(Word w : children){
				if(w.equals(goalWord)){
					return w.getDepth();
				}
				Queue.add(w);
				w.setDepth(currentWord.getDepth() + 1);
			}
			currentWord.check();
			currentWord = Queue.poll();
		}
		
		return 0;
	}

}
