package spanningUSA;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SpanningUSA {

	public SpanningUSA() {

	}

	public int getMstWeight(HashMap<String, City> cities, String start) {
		HashMap<City, Integer> mst = new HashMap<City, Integer>();
		City currentCity = cities.get(start);
		PriorityQueue<Road> pq = new PriorityQueue<Road>();
		pq.addAll(currentCity.getNeighbors());
		int mstWeight = 0;
		int i = 0;
		while (!pq.isEmpty()) {
			Road currentRoad = pq.poll();
			i++;
			if (mst.containsKey(currentRoad.getDestination())) {
				continue;
			}
			System.out.println(i + ": " + currentRoad.getDestination() + " " + mstWeight);
			pq.addAll(currentCity.getNeighbors());
			mstWeight += currentRoad.getWeight();
			mst.put(currentRoad.getDestination(), 1);

		}
		for (City c : mst.keySet()) {
			System.out.println(c);
		}
		return mstWeight;
	}

}
