package labb6;

public class Edge {
	private int capacityFromA, capacityFromB;
	private Node NodeA, NodeB;
	public Edge(Node A, Node B, int capacity){
		this.NodeA = A;
		this.NodeB = B;
		capacityFromB = capacity;
		capacityFromA = capacity;
	}
}
