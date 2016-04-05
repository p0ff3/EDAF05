package WordLadders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WordLadders {
	HashMap<String, Word> words;
	HashMap<String, LinkedList<Word>> neighborFinder;

	public WordLadders() {
		words = new HashMap<String, Word>();
		neighborFinder = new HashMap<String, LinkedList<Word>>();
	}

	public void readWordsFromFile(String path) throws IOException {
		Parser p = new Parser(path);
		words = p.Parse();
		setNeighbours();
	}

	// TODO: Fixa så alla orden får sina grannar tilldelade.
	// Är det verkligen så simpelt? Nu lägger vi nog till alla kanter dubbla
	// gånger.
	// Är det nödvändigt att checka om den redan finns?
	private void setNeighbours() {
		makeNeighborFinder();
		for (Map.Entry<String, Word> entry : words.entrySet()) {
			String lastFour = entry.getValue().getLastFour();
			if (neighborFinder.containsKey(lastFour)) {
				for (Word w : neighborFinder.get(lastFour)) {
					//System.out.println(entry.getValue() + " has possible neighbours " + neighborFinder.get(lastFour));
					if (!w.equals(entry.getValue())) {
						entry.getValue().addNeighbour(w);
					}
				}
			}
		}
	}

	/**
	 * Determines if there is an edge between s1 and s2 using ' ' and '\' as
	 * protected characters.
	 * 
	 * @param s2
	 * @param s1
	 * @return true if edge, otherwise false
	 */
	// TODO: Fix solid null-objects here. Use '\0'?
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
		if(start.equals(goal)){
			return 0;
		}
		LinkedList<Word> Queue = new LinkedList<Word>();
		HashMap<Word, Boolean> checked = new HashMap<Word, Boolean>();
		Word currentWord = words.get(start);
		currentWord.setDepth(0);
		Word goalWord = words.get(goal);
		Queue.add(currentWord);
		while (!Queue.isEmpty()) {
			if (checked.get(currentWord) != null) {
				currentWord = Queue.poll();
				continue;
			}
			ArrayList<Word> children = currentWord.getNeighbours();
			System.out.println(currentWord + " has children: " + children);
			for (Word w : children) {
				System.out.println(w + " " + (checked.get(w)));
				System.out.println("queue: " + Queue);
				
				if (w.equals(goalWord)) {
					return currentWord.getDepth() + 1;
				}
				Queue.add(w);
				w.setDepth(currentWord.getDepth() + 1);
			}
			checked.put(currentWord, true);
			currentWord = Queue.poll();
		}

		return -1;
	}

	// Verkar faktiskt funka. Om man bortser från dubbla bokstäver.
	public void makeNeighborFinder() {
		for (Map.Entry<String, Word> entry : words.entrySet()) {
			String word = entry.getKey();
			char[] wordArray = word.toCharArray();
			Arrays.sort(wordArray);
			for (int i = 0; i < 5; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 5; j++) {
					if (j != i) {
						sb.append(wordArray[j]);
					}
				}
				if (!(neighborFinder.containsKey(sb.toString()))) {
					neighborFinder.put(sb.toString(), new LinkedList<Word>());
					neighborFinder.get(sb.toString()).add(entry.getValue());
				} else {
					neighborFinder.get(sb.toString()).add(entry.getValue());
				}

			}
		}
	}
}
