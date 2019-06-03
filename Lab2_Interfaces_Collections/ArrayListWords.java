/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 2
*
*  This class adds and attempts to find words in an arraylist.  It implements the
CollectionWords interface which includes a put and a get method.
********************************************************/

import java.util.ArrayList;

public class ArrayListWords implements CollectionWords {

    private ArrayList<WordRecord> aList;

    //creates a object of type WordRecord and adds each one to the arraylist
    @Override
    public void put(String name, int value) {
      WordRecord word = new WordRecord(name, value);
      aList.add(word);
    }

    //Overrides get function in interface, traverses through the list to see if String name is in it
    //Returns the value if it is or null if it is not
    @Override
    public Integer get(String name) {
      for(WordRecord wordrecord : aList) {
        if(wordrecord.getName().equals(name)) {
          return wordrecord.getValue();
        }
      }
      return null;
    }

    //constructor for the arrayList aList
    public ArrayListWords(){
      aList = new ArrayList<WordRecord>();
    }
}
