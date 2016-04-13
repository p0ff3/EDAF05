package spanningUSA;

public class Road implements Comparable{
	private int weight;
	private City destination, source;
	

	public Road(City destination, City source, int weight){
		this.weight = weight;
		this.destination = destination;
		this.source = source;
	}

	public int getWeight() {
		return weight;
	}

	public City getDestination() {
		return destination;
	}
	
	public City getSource(){
		return source;
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
