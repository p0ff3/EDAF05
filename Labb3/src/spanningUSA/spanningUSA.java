package spanningUSA;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class spanningUSA {

	Map<String, City> cities;
	public spanningUSA(){
		cities = new HashMap<String, City>();
	}
	
	public void readCitiesFromFile(String path) throws IOException{
		Parser p = new Parser(path);
		cities = p.Parse();
	}
	
}
