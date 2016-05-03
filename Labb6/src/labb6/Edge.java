package labb6;

public class Edge {
	private int capacityFromA, capacityFromB;
	private Node NodeA = null;
	private Node NodeB = null;

	public Edge(Node A, Node B, int capacity) {
		this.NodeA = A;
		this.NodeB = B;
		capacityFromB = capacity;
		capacityFromA = capacity;
	}

	public Node getDestination(Node source) {
		if (NodeA == source) {
			return NodeB;
		}
		return NodeA;
	}

	public Node getSource() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getCapacity(Node source) {
		if(source == NodeA){
			
		}
	}
}
