package labb6;

import java.util.ArrayList;

public class Node {
	private String id, name;
	private ArrayList<Edge> edgeList;

	public Node(String id, String name) {
		this.id = id;
		this.name = name;
		edgeList = new ArrayList<Edge>();
	}

	public void addEdge(Edge e) {
		edgeList.add(e);
	}

	public String toString() {
		return id;
	}

	public ArrayList<Node> getNeighbours(Node source) {
		ArrayList<Node> neighbours = new ArrayList<Node>();
		for (Edge e : edgeList) {
			neighbours.add(e.getDestination(source));
		}
		return neighbours;
	}

	public ArrayList<Edge> getEdges() {
		// TODO Auto-generated method stub
		return edgeList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Node other = (Node) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public int getId(){
		return Integer.parseInt(id);
	}

}
