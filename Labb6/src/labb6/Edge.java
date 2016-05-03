package labb6;

public class Edge {
	private int capacityFromA, capacityFromB, initialCapacity;
	private Node NodeA = null;
	private Node NodeB = null;

	public Edge(Node A, Node B, int capacity) {
		this.NodeA = A;
		this.NodeB = B;
		capacityFromB = capacity;
		capacityFromA = capacity;
		initialCapacity = capacity;
	}

	public Node getDestination(Node source) {
		if (NodeA.equals(source)) {
			return NodeB;
		}
		return NodeA;
	}

	public int getCapacity(Node source) {
		if(source.equals(NodeA)){
			return capacityFromA;
		}
		return capacityFromB;

	}
	public int getFlow(){
		return initialCapacity - Math.min(capacityFromA, capacityFromB);
	}
	
	public String toString(){
		return NodeA.toString() + " " + NodeB.toString() + "  -  " + capacityFromA + " " + capacityFromB; 
	}
	
}
