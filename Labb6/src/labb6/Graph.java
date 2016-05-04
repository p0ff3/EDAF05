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
		while (true) {
			path = bfs(source, sink);
			if (path == null) {
				break;
			}
			int minPotentialFlow = Integer.MAX_VALUE;
			Node n = sink;
			for (Edge e : path) {
				if (e.getFlowFromNode(e.getDestination(n)) < minPotentialFlow) {
					minPotentialFlow = e.getFlowFromNode(e.getDestination(n));
				}
				n = e.getDestination(n);

			}
			n = sink;
			for (Edge e : path) {
				n = e.getDestination(n);
				e.changeFlow(minPotentialFlow, n);
			}

			flow = flow + minPotentialFlow;
		}

		return flow;
	}

	public ArrayList<Edge> findMinCut(Node source) {
		LinkedList<Node> queue = new LinkedList<Node>();
		ArrayList<Node> visited = new ArrayList<Node>();
		Node currentNode = Nodes.get(0);
		queue.add(currentNode);
		while (!queue.isEmpty()) {
			currentNode = queue.poll();
			for (Edge e : currentNode.getEdges()) {
				if (!(e.saturated()) && !(visited.contains(e.getDestination(currentNode)))) {
					queue.add(e.getDestination(currentNode));					
					visited.add(e.getDestination(currentNode));
				}
			}
		}
		System.out.println(visited);
		ArrayList<Edge> minCut = new ArrayList<Edge>();
		for (Node n : visited) {
			for (Edge e : n.getEdges()) {
				if (!(visited.contains(e.getDestination(n)))) {
					minCut.add(e);
				}
			}
		}

		return minCut;
	}

	private ArrayList<Edge> bfs(Node source, Node dest) {
		HashMap<Node, Edge> pairing = new HashMap<Node, Edge>();
		LinkedList<Node> queue = new LinkedList<Node>();
		ArrayList<Node> visited = new ArrayList<Node>();
		queue.add(source);
		while (!queue.isEmpty()) {
			Node currentNode = queue.poll();
			if (currentNode.equals(dest)) {
				return getPath(source, dest, pairing);
			}
			for (Edge e : currentNode.getEdges()) {
				if (e.getFlowFromNode(currentNode) != 0
						&& !(visited.contains(e.getDestination(currentNode)))) {
					pairing.put(e.getDestination(currentNode), e);
					queue.add(e.getDestination(currentNode));
					visited.add(e.getDestination(currentNode));
				}
			}
		}

		return null;
	}

	private ArrayList<Edge> getPath(Node source, Node dest,
			HashMap<Node, Edge> pairing) {
		ArrayList<Edge> path = new ArrayList<Edge>();
		Node tempNode = dest;
		while (!tempNode.equals(source)) {
			path.add(pairing.get(tempNode));
			tempNode = pairing.get(tempNode).getDestination(tempNode);
		}
		return path;
	}

}
