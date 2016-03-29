package stableMarriage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
	String path;
	Scanner sc;

	public Parser(String path) throws FileNotFoundException {
		this.path = path;
		sc = new Scanner(path);

	}

	public void parse(List<Man> manList) {
		List<Woman> womanList = new ArrayList<Woman>();
		String nEquals = sc.next(Pattern.compile("\\[n]{1}[=]{1}\\d"));
		int noOfCouples = nEquals.indexOf(2);
		System.out.println("Number of couples: " + noOfCouples);

		while (sc.hasNext(Pattern.compile("\\d+\\ \\w+"))) {
			String person[] = sc.next(Pattern.compile("\\d+\\ \\w+")).split(
					"\\s+");
			int id = Integer.parseInt(person[0]);
			if (id % 2 == 0) {
				womanList.add(new Woman(id, person[1]));
			} else {

				manList.add(new Man(id, person[1]));
			}
		}
		Scanner prioScanner = new Scanner(path);
		while (prioScanner.hasNext(Pattern.compile("\\d+:( \\d+)+"))) {

			String str = prioScanner.next(Pattern.compile("\\d+:( \\d+)+"));
			String[] prioList = str.split(" ");
			if (Integer.parseInt(prioList[0].substring(0,
					prioList[0].length() - 1)) % 2 == 0) {
				// Denna linen.
				Man m = manList.get(Integer.parseInt(prioList[0].substring(0,
						prioList[0].length() - 1)));
				for (int i = 1; i < noOfCouples; i++) {
					// Är nästan lika bra som denna
					m.addWomanAtEndOfList(womanList.get(Integer
							.parseInt(prioList[i]) / 2));
				}
			} else {
				
			}
		}

	}

	public Man createManFromLine() {
		return null;
	}

	public Woman createWomanFromLine() {
		return null;
	}

	private String readLine() {
		return "";

	}
}
