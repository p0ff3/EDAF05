package spanningUSA;

import java.util.HashMap;
import java.util.Map;

public class City {

	String name;
	//Lista med grannstäder, key är distans, value är namnet på staden/skulle kunna ha object City också.
	Map<Integer, String> neighborCities;
	
	public City(String name){
		this.name = name;
		neighborCities = new HashMap<Integer, String>();
	}
	
	public void addToCityNeighborMap(String name, int distance){
		neighborCities.put(distance, name);
	}
}
	
