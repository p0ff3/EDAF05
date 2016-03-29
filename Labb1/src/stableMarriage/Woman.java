package stableMarriage;

import java.util.HashMap;
import java.util.Map;

public class Woman {
	private int id;
	Map<Integer, Integer> manPrio;
	private int husbandId;

	public Woman() {
		this.id = id;
		manPrio = new HashMap<Integer, Integer>();
		husbandId = -1;
	}

	public void addManToMap(Man m, int prio) {
		manPrio.put(m.getId(), prio);
	}

	public boolean propose(int id) {
		if (husbandId == -1) {
			husbandId = id;
			return true;
		}
		if (manPrio.get(id) > manPrio.get(husbandId)) {
			husbandId = id;
			return true;
		}
		return false;
	}

}
