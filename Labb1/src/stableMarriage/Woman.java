package stableMarriage;

import java.util.HashMap;
import java.util.Map;

public class Woman {
	private int id;
	Map<Integer, Integer> manPrio;
	Man husband;
	
	public Woman(){
		this.id = id;
		manPrio = new HashMap<Integer, Integer>();
		husband = null;
	}
	
	public void addManToMap(Man m, int prio){
		manPrio.put(m.getId(), prio);
	}

	public boolean propose() {
		// TODO Auto-generated method stub
		return false;
		
	}
	
	

}
