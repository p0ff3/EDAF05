package acceptanceTests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;

import junit.framework.TestCase;

import stableMarriage.Main;

public class AccTest extends TestCase {

	@Test
	public void testFriends() throws FileNotFoundException {
		String[] arguments = new String[] { "testFiles/data/sm-friends-in.txt",
				"output/java-friends-out.txt" };

		Main.main(arguments);
		assertEquals("Friends not properly married", new FileReader(
				"testFiles/data/sm-friends-out.txt"), new FileReader(
				"output/java-friends-out.txt"));
	}

	@Test
	public void testIlliad() throws FileNotFoundException {
		String[] arguments = new String[] { "testFiles/data/sm-illiad-in.txt",
				"output/java-illiad-out.txt" };

		Main.main(arguments);
		assertEquals("Friends not properly married", new FileReader(
				"testFiles/data/sm-illiad-out.txt"), new FileReader(
				"output/java-illiad-out.txt"));
	}

	@Test
	public void testRandom50() throws FileNotFoundException {
		String[] arguments = new String[] { "testFiles/data/sm-random-50-in.txt",
				"output/java-random-50-out.txt" };

		Main.main(arguments);
		assertEquals("Friends not properly married", new FileReader(
				"testFiles/data/sm-random-50-out.txt"), new FileReader(
				"output/java-random-50-out.txt"));
	}
}
