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
		System.out.println(manList);
		//System.out.println("Manlist after parsing: " + manList);
	}
	
	//Printar till filen path
	public void writeSMToFile(String path) {
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(path));
			for (Man m : manList){
				out.write(m.toString() + "\n");
				//out.newLine(); Oklart om detta behövs
			}
			out.close();
		}catch (IOException e){
			
		}
	}
	//Printar i konsolen
	public void writeSMToConsole(){
		for (Man m : manList){
			System.out.println(m.toString() + "\n");
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
	
	public void addMan(Man m){
		manList.add(m);
	}
	

}
