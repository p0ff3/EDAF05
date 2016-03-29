package stableMarriage;

import java.awt.List;
import java.util.LinkedList;
import java.io.*;

public class StableMarriage {
	LinkedList<Man> manList;

	public StableMarriage() {
		manList = new LinkedList<Man>();
	}

	public void readCouplesFromFile(String path) {

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

}
