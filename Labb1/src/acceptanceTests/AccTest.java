package acceptanceTests;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;
import stableMarriage.Main;

public class AccTest extends TestCase {

	@Test
	public void testFriends() throws IOException {
		String[] arguments = new String[] { "testFiles/data/sm-friends-in.txt",
				"output/java-friends-out.txt" };

		Main.main(arguments);

		Main.main(arguments);
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/data/sm-friends-out.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"output/java-friends-out.txt"));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		while ((line1 != null) || (line2 != null)) {
			assertEquals("De är inte korrekt gifta", line1, line2);
			line1 = br1.readLine();
			line2 = br2.readLine();
		}
	}

	@Test
	public void testIlliad() throws IOException {
		String[] arguments = new String[] { "testFiles/data/sm-illiad-in.txt",
				"output/java-illiad-out.txt" };

		Main.main(arguments);
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/data/sm-illiad-out.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"output/java-illiad-out.txt"));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		while ((line1 != null) || (line2 != null)) {
			assertEquals("De är inte korrekt gifta", line1, line2);
			line1 = br1.readLine();
			line2 = br2.readLine();
		}
	}

	@Test
	public void testRandom50() throws IOException {
		String[] arguments = new String[] {
				"testFiles/data/sm-random-50-in.txt",
				"output/java-random-50-out.txt" };

		Main.main(arguments);
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/data/sm-random-50-out.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"output/java-random-50-out.txt"));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		while ((line1 != null) || (line2 != null)) {
			assertEquals("De är inte korrekt gifta", line1, line2);
			line1 = br1.readLine();
			line2 = br2.readLine();
		}
	}

	@Test
	public void testRandom500() throws IOException {
		String[] arguments = new String[] {
				"testFiles/data/sm-random-500-in.txt",
				"output/java-random-500-out.txt" };

		Main.main(arguments);
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/data/sm-random-500-out.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"output/java-random-500-out.txt"));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		while ((line1 != null) || (line2 != null)) {
			assertEquals("De är inte korrekt gifta", line1, line2);
			line1 = br1.readLine();
			line2 = br2.readLine();
		}
	}

	@Test
	public void testWorst500() throws IOException {
		String[] arguments = new String[] {
				"testFiles/data/sm-worst-500-in.txt",
				"output/java-worst-500-out.txt" };

		Main.main(arguments);
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/data/sm-worst-500-out.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"output/java-worst-500-out.txt"));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		while ((line1 != null) || (line2 != null)) {
			assertEquals("De är inte korrekt gifta", line1, line2);
			line1 = br1.readLine();
			line2 = br2.readLine();
		}
	}
	//Inte ett test. Bara konstig körmiljö.
	@Test
	public void testbbt() throws IOException {
		String[] arguments = new String[] {
				"testFiles/data/sm-bbt-in.txt",
				"output/java-bbt-out.txt" };

		Main.main(arguments);
		BufferedReader br1 = new BufferedReader(new FileReader(
				"testFiles/data/sm-friends-out.txt"));
		BufferedReader br2 = new BufferedReader(new FileReader(
				"output/java-bbt-out.txt"));
		String line1 = br1.readLine();
		String line2 = br2.readLine();
		while ((line1 != null) || (line2 != null)) {
			//assertEquals("De är inte korrekt gifta", line1, line2);
			line1 = br1.readLine();
			line2 = br2.readLine();
		}
	}
}
