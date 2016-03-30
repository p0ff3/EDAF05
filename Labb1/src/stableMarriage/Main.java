package stableMarriage;

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
		//SM.writeSMToConsole();
		SM.writeSMToFile(args[1]);
		
	}

}
