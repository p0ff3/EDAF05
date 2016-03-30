package stableMarriage;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SimpleParser {
	String path;

	public SimpleParser(String path) {

		this.path = path;
	}

	public ArrayList<Man> Parsing() throws IOException {
		ArrayList<Man> men = new ArrayList<>();
		ArrayList<Woman> women = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(path));
		String str;
		while ((str = br.readLine()) != null) { 
			StringTokenizer lineAsTokens = new StringTokenizer(str);
			String tempStr = lineAsTokens.nextToken();
			if (tempStr.equals("#")) {
				continue;
			} else if (tempStr.contains(":")) { 
				String id = tempStr.substring(0, tempStr.length() - 1);
				if (Integer.parseInt(id) % 2 == 0) {
					Woman w = women.get((Integer.parseInt(id) -1)/ 2);
					int manCount = 0;
					while (lineAsTokens.hasMoreTokens()) {
						w.addManToMap(men.get(Integer.parseInt(lineAsTokens
								.nextToken())  / 2), manCount);
						manCount++;
					}
				} else {
					Man temp = men.get((Integer.parseInt(id) / 2));
					while (lineAsTokens.hasMoreTokens()) {
						temp.addWomanAtEndOfList(women.get((Integer
								.parseInt(lineAsTokens.nextToken()) -1)/ 2));
					}
				}
			} else if (tempStr.contains("=")) {
			} else {
				if (Integer.parseInt(tempStr) % 2 == 0) {
					women.add(new Woman(lineAsTokens.nextToken()));
				} else {
					men.add(new Man(Integer.parseInt(tempStr) / 2, lineAsTokens.nextToken()));
				}
			}
		}
		return men;

	}
}
