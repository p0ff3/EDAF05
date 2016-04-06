package acceptanceTests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;

import WordLadders.WordLadders;

public class AcceptanceTest {

	@Test
	public void test10Words() throws IOException {
		WordLadders wl = new WordLadders();
		wl.readWordsFromFile("testFiles/words-10.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(
				"Labb2/testFiles/words-10-in.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"Labb2/testFiles/words-10-out.txt"));
		String str = "";
		String str1 = "";
		while ((str = br1.readLine()) != null
				&& (str1 = br2.readLine()) != null) {
			String[] strList = str.split(" ");
			int dist = wl.findShortestPath(strList[0], strList[1]);
			assertEquals("Path between " + strList[0] + " and " + strList[1],
					Integer.parseInt(str1), dist);
		}
	}

	@Test
	public void test250Words() throws IOException {
		WordLadders wl = new WordLadders();
		wl.readWordsFromFile("testFiles/words-250.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/words-250-in.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"testFiles/words-250-out.txt"));
		String str = "";
		String str1 = "";
		while ((str = br1.readLine()) != null
				&& (str1 = br2.readLine()) != null) {
			String[] strList = str.split(" ");
			int dist = wl.findShortestPath(strList[0], strList[1]);
			assertEquals("Path between " + strList[0] + " and " + strList[1],
					Integer.parseInt(str1), dist);
		}
	}

	@Test
	public void test5757Words() throws IOException {
		WordLadders wl = new WordLadders();
		wl.readWordsFromFile("testFiles/words-5757.txt");
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/words-5757-in.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"testFiles/words-5757-out.txt"));
		String str = "";
		String str1 = "";
		while ((str = br1.readLine()) != null
				&& (str1 = br2.readLine()) != null) {
			String[] strList = str.split(" ");
			int dist = wl.findShortestPath(strList[0], strList[1]);
			assertEquals("Path between " + strList[0] + " and " + strList[1],
					Integer.parseInt(str1), dist);
		}
	}

}
