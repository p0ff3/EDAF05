package spanningUSA;

import java.io.IOException;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningUSA {
	HashMap<String, City> cities;
	public SpanningUSA() {
		cities = null;
	}

	public void initiateGraph(){
		Parser p = new Parser("highWays.txt");
		try {
			cities = p.Parse();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Wrong path");
		}
	}
	
	public int getMstWeight(String start) {
		HashMap<City, Integer> mst = new HashMap<City, Integer>();
		City currentCity = cities.get(start);
		Road currentRoad = null;
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		mst.put(currentCity, 0);
		pq.addAll(currentCity.getNeighbors());
		int weight = 0;
		while (!pq.isEmpty()) {
			currentRoad = pq.poll();
			if (mst.get(currentRoad.getDestination()) != null) {
				continue;
			}
			System.out.println(currentRoad.getSource() + " -- " + currentRoad.getDestination());
			mst.put(currentRoad.getDestination(), currentRoad.getWeight());
			pq.addAll(currentRoad.getDestination().getNeighbors());
		}
		for(int i : mst.values()){
			weight = weight + i;
		}
		return weight;
	}

}
