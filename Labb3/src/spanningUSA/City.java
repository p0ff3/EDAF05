package spanningUSA;

import java.util.LinkedList;

public class City {
	private String name;
	private LinkedList<Road> neighborCities;

	public City(String name) {
		this.name = name;
		neighborCities = new LinkedList<Road>();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	public void addToCityNeighborMap(City dest, int distance) {
		neighborCities.add(new Road(dest, this, distance));
	}
	
	public String toString() {
		return name;
	}

	public LinkedList<Road> getNeighbors() {
		return neighborCities;
	}
}
