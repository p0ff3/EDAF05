package labb6;

import java.util.ArrayList;

public class Graph {
	ArrayList<Node> Nodes = null;

	public Graph(ArrayList<Node> NodeList) {
		Nodes = NodeList;
	}

	public int getMaxFlow(Node source, Node sink) {
		ArrayList<Edge> path = new ArrayList<Edge>();
		int flow = 0;
		path = getAFlow(source, sink, new ArrayList<Edge>());
		while (path != null) {
			path = getAFlow(source, sink, new ArrayList<Edge>());
			int minPotentialFlow = Integer.MAX_VALUE;
			for(Edge e : path){
				if(e.getPotentialFlow() < minPotentialFlow){
					minPotentialFlow = e.getPotentialFlow();
				}
			}
			for(Edge e : path){
				
			}
			
			flow = flow + minPotentialFlow;
		}

		return flow;
	}

	private ArrayList<Edge> getAFlow(Node source, Node dest,
			ArrayList<Edge> path) {
		if (source == dest) {
			return path;
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
