package stableMarriage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parser {
	private String path;
	private Scanner sc;

	public Parser(String path) throws FileNotFoundException {
		this.path = path;
		sc = new Scanner(new File(path));

	}

	public void parse(LinkedList<Man> manList) {
		List<Woman> womanList = new ArrayList<Woman>();
		while (!sc.hasNext(Pattern.compile("n{1}[=]{1}\\d+"))) {
			sc.nextLine();
		}
		String nEquals = sc.findInLine(Pattern.compile("n{1}[=]{1}\\d+"));
		String couples = nEquals.substring(2);
		int noOfCouples = Integer.parseInt(couples);
		System.out.println("Number of couples: " + noOfCouples);
		//System.out.println(sc.nextLine());
		while (sc.nextLine() != null) {
			String str = sc.findInLine(Pattern.compile("\\d+\\ \\w+"));
			String[] person = {};
			if (str != null) {
				person = str.split("\\s+");
			}
			else{
				break;
			}
			int id = Integer.parseInt(person[0]);
			System.out.println("id: " + id);
			if (id % 2 == 0) {
				womanList.add(new Woman(id, person[1]));
			} else {
				System.out.println("Jag lägger till man här");
				manList.add(new Man(id, person[1]));
			}
		}
		@SuppressWarnings("resource")
		Scanner prioScanner = new Scanner(path);
		while (prioScanner.hasNext(Pattern.compile("\\d+:( \\d+)+"))) {

			String str = prioScanner.next(Pattern.compile("\\d+:( \\d+)+"));
			String[] prioList = str.split(" ");
			int id = Integer.parseInt(prioList[0].substring(0,
					prioList[0].length() - 1));
			if (!(id % 2 == 0)) {
				Man m = manList.get(id);
				for (int i = 1; i < noOfCouples; i++) {
					m.addWomanAtEndOfList(womanList.get(Integer
							.parseInt(prioList[i]) / 2));
				}
			} else {
				for (int i = 1; i < noOfCouples; i++) {
					womanList.get(id).addManToMap(
							manList.get(Integer.parseInt(prioList[i]) / 2), i);
				}
			}
		}

	}
}
