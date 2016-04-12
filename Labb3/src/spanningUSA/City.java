package spanningUSA;

import java.util.LinkedList;

public class City {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	private String name;
	private LinkedList<Road> neighborCities;

	public City(String name) {
		this.name = name;
		neighborCities = new LinkedList<Road>();
	}

	public void addToCityNeighborMap(City dest, int distance) {
		neighborCities.add(new Road(dest, distance));
	}
	
	public String toString(){
		return name;
	}
	
	public LinkedList<Road> getNeighbors(){
		return neighborCities;
	}
}
