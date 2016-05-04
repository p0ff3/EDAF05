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
	
	public int getFlowFromNode(Node n){
		if(n.equals(NodeA)){
			return capacityFromA;
		}
		else{
			return capacityFromB;
		}
	}

	public int getFlow(){
		return initialCapacity - Math.min(capacityFromA, capacityFromB);
	}
	
	public String toString(){
		return NodeA.toString() + " - " + NodeB.toString(); 
	}

	public int getPotentialFlow() {
		return initialCapacity - getFlow();
	}
	
	public boolean saturated(){
		if(capacityFromA == 0 || capacityFromA == 0){
			return true;
		}
		return false;
	}
	
	public void changeFlow(int i, Node n){
		if(n.equals(NodeA)){
			capacityFromB = capacityFromB + i;
			capacityFromA = capacityFromA - i;
		} else{
			capacityFromB = capacityFromB - i;
			capacityFromA = capacityFromA + i;
		}
		if(capacityFromA < 0 || capacityFromB < 0){
			System.out.println("CapcityFromA: " + capacityFromA + ". CapacityFromB: " + capacityFromB);
		}
		
	}
}
