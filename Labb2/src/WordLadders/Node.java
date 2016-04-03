package WordLadders;

import java.util.ArrayList;

public class Node {
	private String word;
	private ArrayList<Node> children;

	public Node(String word){
		this.word = word;
		children = new ArrayList<Node>();
	}

}	

