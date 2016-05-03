package labb6;

import java.util.ArrayList;

public class Graph {
	ArrayList<Node> Nodes = null;

	public Graph(ArrayList<Node> NodeList) {

	}

	public int getMaxFlow(String source, String sink) {
		return 0;
	}

	public ArrayList<Edge> getMinCut(String source, String sink) {
		return null;
	}

	private ArrayList<Edge> getAFlow(Node source, Node dest, ArrayList<Edge> path){
		if(source == dest){
			return null;
		}
		for(Edge e : source.getEdges()){
			if(!path.contains(e)){
				path.add(e);
				ArrayList<Edge> result = getAFlow(e.getSource(), dest, path);
				if(result != null){
					return result;
				}
			}
		}
		
		return null;
	}

}
