package labb6;

import java.util.ArrayList;

public class Graph {
	ArrayList<Node> Nodes = null;

	public Graph(ArrayList<Node> NodeList) {
		Nodes = NodeList;
	}

	public int getMaxFlow(String source, String sink) {
		return 0;
	}

	public ArrayList<Edge> getMinCut(Node source, Node sink) {
		ArrayList<Edge> path = null;
		while (path != null) {
			path = getAFlow(source, sink, new ArrayList<Edge>());
			int minPotentialFlow = Integer.MAX_VALUE;
			for(Edge e : path){
				minPotentialFlow = Math.max(minPotentialFlow, e.getPotentialFlow());
			}
		}

		return null;
	}

	private ArrayList<Edge> getAFlow(Node source, Node dest,
			ArrayList<Edge> path) {
		if (source == dest) {
			return null;
		}
		for (Edge e : source.getEdges()) {
			if (!path.contains(e)) {
				path.add(e);
				ArrayList<Edge> result = getAFlow(e.getDestination(source),
						dest, path);
				if (result != null) {
					return result;
				}
			}
		}

		return null;
	}

}
