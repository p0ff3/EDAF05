package stableMarriage;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StableMarriage SM = new StableMarriage();
		SM.readCouplesFromFile(args[0]);
		SM.writeStableMatchingToFile(args[1]);
	}

}
