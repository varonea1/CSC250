// simple object to encapsulate a (name, value) pair in a Collection
public class WordRecord {
  private String name;  // the name
	private int value;    // the value

	// constructor
	public WordRecord(String key, int value) {
	  this.name = key;
		this.value = value;
	}

	// return String name
	public String getName() {
	    return this.name;
	}

	// return int value
	public int getValue() {
	    return this.value;
	}
}
