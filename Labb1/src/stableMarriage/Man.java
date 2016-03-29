package stableMarriage;

import java.util.LinkedList;

public class Man {
	private int id;
	Woman wife;
	private boolean marriedStatus;
	LinkedList<Woman> womanPrio;

	public Man(int id) {
		this.id = id;
		womanPrio = new LinkedList<Woman>();
		wife = null;
		marriedStatus = false;
	}

	public void addWomanAtEndOfList(Woman w) {
		womanPrio.add(w);
	}

	public void getMarried() {
			Woman w = womanPrio.poll();
			if (w.propose(id)) {
				wife = w;
				marriedStatus = true;
			}
	}

	public void divorce() {
		wife = null;
		marriedStatus = false;
		getMarried();
	}
	
	public int getId(){
		return id;
	}
	
	public boolean isMarried(){
		return marriedStatus;
	}

}
