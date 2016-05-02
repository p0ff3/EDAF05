package labb6;

import java.util.ArrayList;

public class Node {
	private String id, name;
	private ArrayList<Edge> edgeList;
	
	public Node(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public void addEdge(Edge e){
		edgeList.add(e);
	}

}
