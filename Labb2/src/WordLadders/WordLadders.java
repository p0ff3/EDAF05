package WordLadders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class WordLadders {
	HashMap<String, Word> words;

	public WordLadders() {
		words = new HashMap<String, Word>();
	}
	public void readWordsFromFile(String path) throws IOException {
		Parser p = new Parser(path);
		words = p.Parse();
		setNeighbours();
	}
	
	//TODO: Fixa så alla orden får sina grannar tilldelade.
	private void setNeighbours(){
		
	}
	
	/**
	 * Determines if there is an edge between s1 and s2 using ' ' and '\' as protected characters.
	 * @param s2
	 * @param s1 
	 * @return true if edge, otherwise false
	 */
	//TODO: Fix solid null-objects here. Use '\0'?
	public boolean isNeighbors(String s1, String s2) {
		char[] a = s1.substring(1, s2.length()).toCharArray();
		char[] b = s2.toCharArray();
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (a[i] == b[j]) {
					b[j] = ' ';
					a[i] = '\\';
					count++;
				}
			}
		}

		if (count >= 4) {
			return true;
		}
		return false;
	}
	
	public int findShortestPath(String start, String goal) {
		LinkedList<Word> Queue= new LinkedList<Word>();
		Word currentWord = words.get(start);
		currentWord.setDepth(0);
		Word goalWord = words.get(goal);
		Queue.add(currentWord);
		while(!Queue.isEmpty()){
			if(currentWord.isChecked()){
				currentWord = Queue.poll();
				continue;
			}
			ArrayList<Word>children = currentWord.getNeighbours();
			for(Word w : children){
				if(w.equals(goalWord)){
					return currentWord.getDepth() + 1;
				}
				Queue.add(w);
				w.setDepth(currentWord.getDepth() + 1);
			}
			currentWord.check();
			currentWord = Queue.poll();
		}
		
		return -1;
	}

}
