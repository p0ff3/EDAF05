package labb6;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	ArrayList<Node> Nodes = null;

	public Graph(ArrayList<Node> NodeList) {

	}

	public int getMaxFlow(String source, String sink) {
		return 0;
	}

	public ArrayList<Node> getMinCut(String source, String sink) {
		return null;
	}

	private int breadthFirstSearch(Node source, Node destination) {
		LinkedList<Edge> Q = new LinkedList<Edge>();
		int capacity = 0;
		for (Edge e : source.getEdges()) {
			Q.add(e);
		}
		while (!Q.isEmpty()) {
			Edge current = Q.pop();
			source = 
			capacity += Edge.getCapacity(source);
		
		}
		return 0;
	}

}
