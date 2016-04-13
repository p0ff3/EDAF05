package spanningUSA;

import java.io.IOException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		SpanningUSA spann = new SpanningUSA();
		spann.initiateGraph();
		System.out.println(spann.getMstWeight("Sterling"));

	}

}
