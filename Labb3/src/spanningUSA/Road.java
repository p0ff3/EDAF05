package spanningUSA;

public class Road {
	private int weight;
	private City destination;

	public Road(City destination, int weight) {
		this.weight = weight;
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public City getDestination() {
		return destination;
	}

}
