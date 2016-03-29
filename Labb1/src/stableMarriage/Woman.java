package stableMarriage;

import java.util.HashMap;
import java.util.Map;

public class Woman {
	private int id;
	Map<Integer, Integer> manPrio;
	private int husbandId;
	private String name;
	private Man husband;
	
	public Woman(int id, String name) {
		this.id = id;
		manPrio = new HashMap<Integer, Integer>();
		husbandId = -1;
		this.name = name;
	}

	public void addManToMap(Man m, int prio) {
		manPrio.put(m.getId(), prio);
	}

	public boolean propose(int id, Man m) {
		if (husbandId == -1){
			husbandId = id;
			husband = m;
			return true;
		}
		
		if (manPrio.get(id) < manPrio.get(husbandId)) {
			husbandId = id;
			husband.divorce();
			husband = m;
			return true;
		}
		return false;
	}
	
	public String getName(){
		return name;
	}

}
