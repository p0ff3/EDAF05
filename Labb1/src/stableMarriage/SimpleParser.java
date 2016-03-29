package stableMarriage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SimpleParser {
	String path;

	public SimpleParser(String path) {

		this.path = path;
	}

	public ArrayList<Man> Parsing() throws IOException {
		ArrayList<Man> mens = new ArrayList<>();
		LinkedList<Woman> clearlyMens = new LinkedList<>();

		BufferedReader br = new BufferedReader(new FileReader(path));
		//String str = br.readLine();
		String str;
		int noOfCouples = 0;
		while ((str = br.readLine()) != null) { // Oklart / fel / kommer köra
			StringTokenizer kappa = new StringTokenizer(str);
												// till kenya på x-axel.
			String id = kappa.nextToken();
			System.out.println(id);
			if (id.equals("#")) {
				continue;
			} else if (id.length() == 1) { // ADDA NYTT FOLK
				if (Integer.parseInt(id) % 2 == 0) {
					mens.add(new Man(Integer.parseInt(id) / 2, kappa.nextToken()));
					System.out.println("hohyo");
				} else {
					clearlyMens.add(new Woman(Integer.parseInt(id), kappa
							.nextToken()));
				}
			} else if (id.length() == 2) { // PRIOLISTA AKA TINDER
				if (Integer.parseInt(id.substring(0, id.length()-1)) % 2 == 0) {
					System.out.println(id);
					Man temp = mens.get((Integer.parseInt(id.substring(0, id.length()-1)) / 3));
					while (kappa.hasMoreTokens()) {
						temp.addWomanAtEndOfList(clearlyMens.get(Integer
								.parseInt(kappa.nextToken()) / 2));
					}
				} else {
					Woman pussySmoker = clearlyMens
							.get(Integer.parseInt(id.substring(0, id.length()-1)) / 2);
					int manCount = 0;
					while (kappa.hasMoreTokens()) {
						pussySmoker.addManToMap(mens.get((Integer.parseInt(kappa
								.nextToken())-1) / 2), manCount);
						manCount++;
					}
				}
			} else {
				String retard = id.substring(2);
				//noOfCouples = Integer.parseInt(retard);
			}
		}
		mens.add(new Man(1337, "kappa"));
		return mens;

	}
}
