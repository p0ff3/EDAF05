package stableMarriage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		StableMarriage SM = new StableMarriage();
		SM.readCouplesFromFile(args[0]);
		SM.marryAllTheMen();
		SM.writeSMToConsole();
		SM.writeSMToFile(args[1]);

		//StableMarriage SM = new StableMarriage();
		//SM.readCouplesFromFile(args[0]);
		//SM.writeStableMatchingToFile(args[1]);
	//	StableMarriage sm = new StableMarriage();
		
//		Man ross = new Man(1, "Ross");
//		Man chandler = new Man(3, "Chandler");
//		Man joey = new Man(5, "Joey");
//		Woman monica = new Woman(2, "Monica");
//		Woman phoebe = new Woman(4, "Phoebe");
//		Woman rachel = new Woman(6, "Rachel");
//		
//		sm.addMan(joey);
//		sm.addMan(chandler);
//		sm.addMan(ross);
//		
//		ross.addWomanAtEndOfList(rachel);
//		ross.addWomanAtEndOfList(phoebe);
//		ross.addWomanAtEndOfList(monica);
//		
//		chandler.addWomanAtEndOfList(monica);
//		chandler.addWomanAtEndOfList(rachel);
//		chandler.addWomanAtEndOfList(phoebe);
//		
//		joey.addWomanAtEndOfList(rachel);
//		joey.addWomanAtEndOfList(phoebe);
//		joey.addWomanAtEndOfList(monica);
//		
//		monica.addManToMap(ross, 3);
//		monica.addManToMap(chandler, 1);
//		monica.addManToMap(joey, 2);
//		
//		phoebe.addManToMap(ross, 2);
//		phoebe.addManToMap(chandler, 3);
//		phoebe.addManToMap(joey, 1);
//		
//		rachel.addManToMap(ross, 1);
//		rachel.addManToMap(chandler, 3);
//		rachel.addManToMap(joey, 2);
//		
//		sm.marryAllTheMen();
//		sm.writeSMToConsole();	
		
		
	}

}
