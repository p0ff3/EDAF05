package stableMarriage;

import java.util.HashMap;
import java.util.Map;

public class Woman {
	private int id;
	Map<Integer, Integer> manPrio;
	private int husbandId;
	private String name;
	
	public Woman(int id, String name) {
		this.id = id;
		manPrio = new HashMap<Integer, Integer>();
		husbandId = -1;
		this.name = name;
	}

	public void addManToMap(Man m, int prio) {
		manPrio.put(m.getId(), prio);
	}

	public boolean propose(int id) {
		if (manPrio.get(id) > manPrio.get(husbandId) || husbandId == -1) {
			husbandId = id;
			return true;
		}
		return false;
	}
	
	public String getName(){
		return name;
	}

}
