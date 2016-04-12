package spanningUSA;

import java.io.*;
import java.util.HashMap;

public class Parser {
	String path;

	public Parser(String path) {
		this.path = path;
	}

	// Läs skit
	public HashMap<String, City> Parse() throws IOException {
		HashMap<String, City> cityMap = new HashMap<String, City>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str;
			while ((str = br.readLine()) != null) {
				if (!str.contains("[")) {
					cityMap.put(str, new City(str));
				} else {					 // Har ska vi läsa en stad, Lägga in den andra staden
											// och distans dit i den stadens HashMap,
					int index = str.indexOf("--");
					String cityName = str.substring(0, index); //index-1?
					String targetCity = str.substring(index + 1, str.indexOf(" "));
					String distance = str.substring(str.indexOf("["), str.indexOf("]"));
					int nbrDistance = Integer.parseInt(distance);
					City temp;
					temp = cityMap.get(cityName);
					temp.addToCityNeighborMap(targetCity, nbrDistance);
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("Filen hittades inte.");
			e.printStackTrace();
		}
		return cityMap;

	}
}