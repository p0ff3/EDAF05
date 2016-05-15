package labb6;


public class Edge {
	private int capacityFromA, capacityFromB, initialCapacity;
	private Node NodeA;
	private Node NodeB;

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

	public int getInitCap(){
		return initialCapacity;
	}
	
	public int getFlow(){
		return initialCapacity - Math.min(capacityFromA, capacityFromB);
	}
	
	public String toString(){
		return NodeA.toString() + " - " + NodeB.toString() + " flow: " + getFlow(); 
	}

	public int getPotentialFlow() {
		return initialCapacity - getFlow();
	}
	
	public boolean saturated(){
		if(getFlow() == initialCapacity){
			return true;
		}
		return false;
	}
	
	public void changeFlow(int i, Node n){
		if(n.equals(NodeA)){
			capacityFromB = capacityFromB + i;
			capacityFromA = capacityFromA - i;
		} else if(n.equals(NodeB)){
			capacityFromB = capacityFromB - i;
			capacityFromA = capacityFromA + i;
		} else{
			System.out.println("wtf dude");
		}
		if(capacityFromA < 0 || capacityFromB < 0){
			System.out.println("CapcityFromA: " + capacityFromA + ". CapacityFromB: " + capacityFromB);
		}
		
	}
}
