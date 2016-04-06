package WordLadders;

import java.io.IOException;
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

	private void setNeighbours() {
		makeNeighborFinder();
		for (Map.Entry<String, Word> entry : words.entrySet()) {
			String lastFour = entry.getValue().getLastFour();
			if (neighborFinder.containsKey(lastFour)) {
				for (Word w : neighborFinder.get(lastFour)) {
					if (!w.equals(entry.getValue())) {
						entry.getValue().addNeighbour(w);
					}
				}
			}
		}
	}

	public int findShortestPath(String start, String goal) {
		for (Map.Entry<String, Word> entry : words.entrySet()) {
			entry.getValue().setDepth(-2);
		}
		if (start.equals(goal)) {
			return 0;
		}
		LinkedList<Word> Queue = new LinkedList<Word>();
		Word currentWord = words.get(start);
		currentWord.setDepth(0);
		Word goalWord = words.get(goal);
		Queue.add(currentWord);
		while (!Queue.isEmpty()) {
			currentWord = Queue.poll();
			LinkedList<Word> children = currentWord.getNeighbours();
			for (Word w : children) {
				if (w.getDepth() == -2) {
					if (w.equals(goalWord)) {
						return currentWord.getDepth() + 1;
					}
					w.setDepth(currentWord.getDepth() + 1);
					Queue.add(w);
				}

			}
		}

		return -1;
	}

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
