package labb6;

import java.io.*;
import java.util.ArrayList;

public class Parser {
	private String path;

	public Parser(String path) {
		this.path = path;
	}

	public ArrayList<Node> Parse() throws IOException {
		ArrayList<Node> list = new ArrayList<Node>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str;
			int nodes;
			str = br.readLine();
			nodes = Integer.parseInt(str);
			for (int i = 0; i < nodes; i++) {
				str = br.readLine();
				list.add(new Node(Integer.toString(i), str));
			}
			br.readLine();
			while ((str = br.readLine()) != null) {
				String[] info = str.split("\\s+");
				int[] infoInt = new int[3];
				int rkn = 0;
				for (String s : info) {
					infoInt[rkn] = Integer.parseInt(s);
					rkn++;
				}
				Edge e = new Edge(list.get(infoInt[0]), list.get(infoInt[1]),
						infoInt[2]);
				list.get(infoInt[0]).addEdge(e);
				list.get(infoInt[1]).addEdge(e);

			}

		} catch (FileNotFoundException e) {
			System.out.println("KappaPride");
			e.printStackTrace();
		}
		return list;
	}
}