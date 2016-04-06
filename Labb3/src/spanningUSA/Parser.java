package spanningUSA;

import java.io.*;
import java.util.HashMap;

public class Parser {
	String path;

	public Parser(String path) {
		this.path = path;
	}

	// Oklart vad vi vill returnera
	public HashMap<String, Word> Parse() throws IOException {
		HashMap<String, Word> wordList = new HashMap<String, Word>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String str;
			while ((str = br.readLine()) != null) {
				wordList.put(str, new Word(str));
			}

		} catch (FileNotFoundException e) {
			System.out.println("Filen hittades inte.");
			e.printStackTrace();
		}
		return wordList;

	}
}