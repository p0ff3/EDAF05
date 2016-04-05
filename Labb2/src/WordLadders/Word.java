package WordLadders;

import java.util.ArrayList;
import java.util.Arrays;


public class Word {

	private String name;
	private ArrayList<Word> neighbours;
	private boolean isChecked = false;
	private int depth;

	public Word(String name) {
		this.name = name;
		neighbours = new ArrayList<Word>();
	}

	public ArrayList<Word> getNeighbours() {
		return neighbours;
	}

	public void addNeighbour(Word neighbour) {
		this.neighbours.add(neighbour);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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

	public void check() {
		isChecked = true;
		
	}
	public boolean isChecked(){
		return isChecked;
	}

	public int getDepth() {
		return depth;
	}
	
	public void setDepth(int i){
		depth = i;
	}
	
	@Override
	public String toString(){
		return name;
	}
	
	public String getLastFour(){
		char[] c = name.toCharArray();
		char[] c2 = Arrays.copyOfRange(c, 1, 5);
		Arrays.sort(c2);
		StringBuilder sb = new StringBuilder();
		for(char kappa : c2){
			sb.append(kappa);
		}
		return sb.toString();
	}
}
