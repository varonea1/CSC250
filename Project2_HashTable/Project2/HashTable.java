/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Project 2
*
*  This class creates a hashtable.  It has two constructors, the defaulkt constructor initializes the table to 3 buckets.
This class has methods find, insert, erase, and size which each call different methods in the SLL.
********************************************************/

public class HashTable {
    int tableSize; // table size
    SLL[] table;

    // default constructor, which uses default table size 3
    public HashTable() {
        this.tableSize = 3;
        this.table = new SLL[3];
        for(int i = 0; i < 3; i++) {
          table[i] = new SLL();
        }
    }

    // constructor, which uses size as the table size
    public HashTable(int size) {
        this.tableSize = size;
        this.table = new SLL[size];
        //for loop that initializes each array of type SLL
        for(int i = 0; i < this.tableSize; i++) {
          table[i] = new SLL();
        }
    }

    // search for item in the table
    // if found return true
    // else return false
    public boolean find(String item) {
      int key = Integer.parseInt(item);
      int hashCode = key % tableSize;
      if(table[hashCode].search(item) != null) {
        return true;
      }
      else {
        return false;
      }
    }

    // insert (item1, item2) to the table
    // use item1 as the key
    public void insert(String item1, String item2) {
      int key = Integer.parseInt(item1);
      int hashCode = key % tableSize;
      table[hashCode].insert(item1, item2);
    }

    // delete the pair whose key value is item
    // if deleted return true
    // else return false
    public boolean erase(String item) {
      //converts the SLL string to an int
      int key = Integer.parseInt(item);
      //calculates the hashcode
      int hashCode = key % tableSize;
      if(table[hashCode].search(item) != null) {
        table[hashCode].remove(item);
        return true;
      }
      else {
        return false;
      }
    }

    // return the total number of nodes in the hash table
    public int getSize() {
      int counter = 0;
      for(int i = 0; i < tableSize; i++) {
        counter += table[i].getSize();
      }
      return counter;
    }

}
