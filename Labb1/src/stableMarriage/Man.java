package stableMarriage;

import java.util.LinkedList;

public class Man {
	int id;
	boolean married = false;
	Woman wife;
	LinkedList<Woman> womanList;

	public Man(int id) {
		this.id = id;
		womanList = new LinkedList<Woman>();
	}

	public void addWomanAtEndOfList(Woman w) {
		womanList.add(w);
	}

	public void getMarried() {
		while (!married) {
			Woman w = womanList.poll();
			if (w.propose()) {
				wife = w;
				married = true;
			}
		}
	}

	public void divorce() {
		wife = null;
		married = false;
		getMarried();
	}

}
