package labb6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	ArrayList<Node> Nodes = null;

	public Graph(ArrayList<Node> NodeList) {
		Nodes = NodeList;
	}

	public int getMaxFlow(Node source, Node sink) {
		ArrayList<Edge> path = new ArrayList<Edge>();
		int flow = 0;
		path = bfs(source, sink);
		while (path != null) {
			System.out.println(flow);
			path = bfs(source, sink);
			int minPotentialFlow = Integer.MAX_VALUE;
			for (Edge e : path) {
				if (e.getPotentialFlow() < minPotentialFlow) {
					minPotentialFlow = e.getPotentialFlow();
				}
			}
			Node n = source;
			for (Edge e : path) {
				n = e.getDestination(n);
				e.changeFlow(minPotentialFlow, n);
			}

			flow = flow + minPotentialFlow;
		}

		return flow;
	}

	private ArrayList<Edge> bfs(Node source, Node dest) {
		HashMap<Node, Edge> pairing = new HashMap<Node, Edge>();
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if (currentNode.equals(dest)) {
				return getPath(source, dest, pairing);
			}
			for (Edge e : currentNode.getEdges()) {
				if (e.getFlowFromNode(currentNode) != 0) {
					pairing.put(e.getDestination(currentNode), e);
					queue.add(e.getDestination(currentNode));
				}
			}
		}

		return null;
	}

	private ArrayList<Edge> getPath(Node source, Node dest,
			HashMap<Node, Edge> pairing) {
		ArrayList<Edge> path = new ArrayList<Edge>();
		Node tempNode = source;
		while (!tempNode.equals(dest)) {
			path.add(pairing.get(tempNode));
			tempNode = pairing.get(tempNode).getDestination(tempNode);
		}
		return path;
	}

}
