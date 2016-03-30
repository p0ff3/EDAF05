package stableMarriage;

import java.util.LinkedList;

public class Man {
	private int id;
	Woman wife;
	private boolean marriedStatus;
	LinkedList<Woman> womanPrio;
	private String name;

	public Man(int id, String name) {
		this.id = id;
		womanPrio = new LinkedList<Woman>();
		wife = null;
		marriedStatus = false;
		this.name = name;
	}

	public void printPrioList() {
		System.out.println(womanPrio);
	}

	public void addWomanAtEndOfList(Woman w) {
		womanPrio.add(w);
	}

	public void getMarried() {
		while (this.marriedStatus == false) {
			Woman w = womanPrio.poll();
			if (w.propose(id, this)) {
				wife = w;
				marriedStatus = true;
			}
		}
	}

	public void divorce() {
		wife = null;
		marriedStatus = false;
		// getMarried();
	}

	public int getId() {
		return id;
	}

	public boolean isMarried() {
		return marriedStatus;
	}

	public String toString() {
		if (wife != null) {
			return name + " -- " + wife.getName();
		} else {
			return name + " -- null";
		}
	}

}
