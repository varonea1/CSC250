import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

// benchmark performance of several different collections
public class Benchmark {

	// benchmark time to put and get values from an ArrayList Collection
	private static void testCollection(CollectionWords collect, String word, int times) throws IOException {
	    long startTime, endTime;
			Integer value = null;

		// fill the Collection with dictionary words
		startTime = System.currentTimeMillis();
		FileInputStream fis = new FileInputStream("words.txt");
		Scanner scnr = new Scanner(fis);

		int index = 0;
		while (scnr.hasNextLine()) {
		    collect.put(scnr.nextLine(), index++);
		}

		endTime = System.currentTimeMillis();
		System.out.printf("  %d msec to add %d words\n", (endTime - startTime), index);

		// search for word in the collection
		startTime = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			value = collect.get(word);
		}

		endTime = System.currentTimeMillis();
		if (value != null)
		    System.out.printf("    %d msec to find \"%s\" %.1e times\n", (endTime - startTime), word, (double)times);
		else
		    System.out.printf("    %d msec to NOT find \"%s\" %.1e times\n", (endTime - startTime), word, (double)times);
	}


	// main testbench method
	public static void main(String [] args) throws IOException {
		System.out.println("Testing ArrayList...");
		ArrayListWords a = new ArrayListWords();
	    testCollection(a, "Aaron", (int)1e4);
	    testCollection(a, "harmless", (int)1e4);
	    testCollection(a, "zygote", (int)1e4);
	    testCollection(a, "zzzzzz", (int)1e4);

		System.out.println("\nTesting Collection...");
		HashMapWords h = new HashMapWords();
	    testCollection(h, "Aaron", (int)1e8);
	    testCollection(h, "harmless", (int)1e8);
	    testCollection(h, "zygote", (int)1e8);
	    testCollection(h, "zzzzzz", (int)1e8);
	}

}
