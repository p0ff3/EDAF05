package stableMarriage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.io.*;

public class StableMarriage {
	ArrayList<Man> manList;

	public StableMarriage() {
		manList = new ArrayList<>();
	}

	public void readCouplesFromFile(String path) throws IOException {
		SimpleParser p = new SimpleParser(path);
		manList = p.Parsing();
	}

	public void writeSMToFile(String path) {
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			for (Man m : manList) {
				out.write(m.toString() + "\n");
			}
			out.close();
		} catch (IOException e) {

		}
	}

	public void writeSMToConsole() {
		for (Man m : manList) {
			System.out.println(m.toString());
		}
	}

	public void marryAllTheMen() {
		boolean everyoneIsMarried = true;
		do {
			everyoneIsMarried = true;
			for (Man m : manList) {
				if (!m.isMarried()) {
					everyoneIsMarried = false;
					m.getMarried();
				}
			}
		} while (!everyoneIsMarried);
	}

	public void addMan(Man m) {
		manList.add(m);
	}

}
