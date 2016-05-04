package labb6;

import java.util.HashMap;

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

	public int getFlow(){
		return initialCapacity - Math.min(capacityFromA, capacityFromB);
	}
	
	public String toString(){
		return NodeA.toString() + " " + NodeB.toString() + "  -  " + capacityFromA + " " + capacityFromB; 
	}

	public int getPotentialFlow() {
		return initialCapacity - getFlow();
	}
	
	public void changeFlow(int i, Node n){
		if(n.equals(NodeA)){
			capacityFromB = capacityFromB + i;
			capacityFromA = capacityFromA - i;
		} else{
			capacityFromB = capacityFromB - i;
			capacityFromA = capacityFromA + i;
		}
		
	}
}
