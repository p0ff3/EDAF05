package stableMarriage;

import java.util.HashMap;
import java.util.Map;

public class Woman {
	private int id;
	Map<Integer, Integer> manList;
	Man husband;
	public Woman(){
		this.id = id;
		manList = new HashMap<Integer, Integer>();
	}
	
	public void addManToMap(Man m, int prio){
		manlist.add(m.getId(), prio);
	}

	public boolean propose() {
		// TODO Auto-generated method stub
		return false;
		
	}
	
	

}
