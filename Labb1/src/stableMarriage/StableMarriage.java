package stableMarriage;

import java.awt.List;
import java.util.LinkedList;

public class StableMarriage {
	LinkedList<Man> manList;
	public StableMarriage(){
		manList = new LinkedList<Man>();
	}
	public void readCouplesFromFile(String path){
		
	}
	public void writeStableMatchingToFile(String path){

	}
	
	public void marrypepes(){
		boolean everyoneIsMarried = true;
		do{
		for(Man m : manList){
			if(!m.isMarried())
				everyoneIsMarried = false;
				m.getMarried();
		}
		}while(!everyoneIsMarried);
	}

}
