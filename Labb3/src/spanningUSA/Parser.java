package spanningUSA;

import java.io.*;
import java.util.HashMap;

public class Parser {
	private String path;

	public Parser(String path) {
		this.path = path;
	}

	public HashMap<String, City> Parse() throws IOException {
		HashMap<String, City> cityMap = new HashMap<String, City>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str;
			while ((str = br.readLine()) != null) {
				if (!str.contains("[")) {
					cityMap.put(str.trim(), new City(str));
				} else {
					int index = str.indexOf("--");
					String cityName = str.substring(0, index); // index-1?
					String targetCity = str.substring(index + 2,
							str.lastIndexOf(" "));
					String distance = str.substring(str.indexOf("[") + 1,
							str.indexOf("]"));
					int nbrDistance = Integer.parseInt(distance);
					City temp;
					temp = cityMap.get(cityName);

					temp.addToCityNeighborMap(cityMap.get(targetCity),
							nbrDistance);
					cityMap.get(targetCity).addToCityNeighborMap(temp,
							nbrDistance);
				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("Filen hittades inte.");
			e.printStackTrace();
		}
		return cityMap;

	}
}