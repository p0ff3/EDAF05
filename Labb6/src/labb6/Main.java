package labb6;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Node> testList = new ArrayList<Node>(); 
		Parser p = new Parser("testfiles/rail.txt");
		testList = p.Parse();
		//System.out.println("Skiten är tom");
		//for (Node n : testList){
		//	System.out.println(n.toString());
		//	for(Edge e : n.getEdges()){
		//		System.out.println(e.toString());
		//	}
		// }
		Graph g = new Graph(testList);
		System.out.println("Maxflow: " + g.getMaxFlow(testList.get(0), testList.get(testList.size()-1)));
		System.out.println("Mincut: " + g.findMinCut(testList.get(0), testList.get(testList.size()-1)));
		
	}

}
