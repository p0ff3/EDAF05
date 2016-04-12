package spanningUSA;

public class Road implements Comparable{
	private int weight;
	private City destination;

	public Road(City destination, int weight){
		this.weight = weight;
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public City getDestination() {
		return destination;
	}
	
	private int compareTo(Road r){
		if(weight > r.getWeight()){
			return 1;
		}
		else if(weight < r.getWeight()){
			return -1;
		}
		else{
			return 0;
		}
	}

	@Override
	public int compareTo(Object arg0) {
		return compareTo((Road)arg0);
	}

}
