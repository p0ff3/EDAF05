package spanningUSA;

import java.io.IOException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Parser p = new Parser("test");
		HashMap<String, City> cities = null;
		try {
			cities = p.Parse();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Fel på pathen din bög.");
		}
		SpanningUSA spann = new SpanningUSA();
		System.out.println(spann.getMstWeight(cities, "Sterling"));

	}

}
