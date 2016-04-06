package WordLadders;

import java.util.Arrays;
import java.util.LinkedList;

public class Word {

	private String name;
	private LinkedList<Word> adjacentWords;
	private int depth;

	public Word(String name) {
		this.name = name;
		adjacentWords = new LinkedList<Word>();
	}

	public LinkedList<Word> getNeighbours() {
		return adjacentWords;
	}

	public void addNeighbour(Word neighbour) {
		this.adjacentWords.add(neighbour);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int i) {
		depth = i;
	}

	@Override
	public String toString() {
		return name;
	}

	public String getLastFour() {
		char[] c = name.toCharArray();
		char[] c2 = Arrays.copyOfRange(c, 1, 5);
		Arrays.sort(c2);
		StringBuilder sb = new StringBuilder();
		for (char kappa : c2) {
			sb.append(kappa);
		}
		return sb.toString();
	}
}
