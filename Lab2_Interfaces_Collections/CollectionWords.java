// interface to compare performance of different Collection implementations
public interface CollectionWords {
	// add a (name, value) pair to the collection
    public void put(String name, int value);

	// return the value associated with name in the Collection
	// if name is not found, return null
    public Integer get(String name);
}
