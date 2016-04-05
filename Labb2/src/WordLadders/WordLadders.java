package WordLadders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class WordLadders {
	HashMap<String, Word> words;
	// 5x the size of words, got all possible sorted 4 letter combinations of
	// the 5 letter words.
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
		for (Map.Entry<String, Word> entry : words.entrySet()) {
			String lastFour = entry.getValue().getLastFour();
			if (neighborFinder.containsKey(lastFour)) {
				for (Word w : neighborFinder.get(lastFour)) {
					w.addNeighbour(entry.getValue());
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
		LinkedList<Word> Queue = new LinkedList<Word>();
		Word currentWord = words.get(start);
		currentWord.setDepth(0);
		Word goalWord = words.get(goal);
		Queue.add(currentWord);
		while (!Queue.isEmpty()) {
			if (currentWord.isChecked()) {
				currentWord = Queue.poll();
				continue;
			}
			ArrayList<Word> children = currentWord.getNeighbours();
			for (Word w : children) {
				if (w.equals(goalWord)) {
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

	// Verkar faktiskt funka. Om man bortser från dubbla bokstäver.
	public void makeNeighborFinder() {
		for (Map.Entry<String, Word> entry : words.entrySet()) {
			String word = entry.getKey();
			char[] wordArray = word.toCharArray();
			Arrays.sort(wordArray);
			// How to handle dubbla bokstaver, tex 2 "a"
			for (int i = 0; i < 5; i++) {
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < 5; j++) {
					if (j != i) {
						sb.append(wordArray[j]);
					}
				}
				System.out.println(sb.toString());
				if (!(neighborFinder.containsKey(sb.toString()))) {
					neighborFinder.put(sb.toString(), new LinkedList<Word>());
					neighborFinder.get(sb.toString()).add(entry.getValue());
				} else {
					neighborFinder.get(sb.toString()).add(entry.getValue());
				}

			}
			System.out
					.println(neighborFinder.get("eehw").getFirst().toString());
		}
	}

	public void testPrint() {

	}

}
