package spanningUSA;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningUSA {

	public SpanningUSA() {

	}

	public int getMstWeight(HashMap<String, City> cities, String start) {
		HashMap<City, Integer> mst = new HashMap<City, Integer>();
		City currentCity = cities.get(start);
		Road currentRoad = null;
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		mst.put(currentCity, 1);
		pq.addAll(currentCity.getNeighbors());
		int mstWeight = 0;
		while (!pq.isEmpty()) {
			currentRoad = pq.poll();
			if (mst.get(currentRoad.getDestination()) != null) {
				continue;
			}
			mst.put(currentRoad.getDestination(), 1);
			pq.addAll(currentRoad.getDestination().getNeighbors());
			mstWeight += currentRoad.getWeight();
		}
		for (City c : mst.keySet()) {
			System.out.println(c);
		}
		return mstWeight;
	}

}
