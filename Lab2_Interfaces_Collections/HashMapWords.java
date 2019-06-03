/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 2
*
*  This class adds and attempts to find words in a HashMap.  It implements the
CollectionWords interface which includes a put and a get method.
********************************************************/

import java.util.HashMap;

public class HashMapWords implements CollectionWords {

    private HashMap<String, Integer> map;

    //adds each word to the map using the put call
    @Override
    public void put(String name, int value){
      map.put(name, value);
    }

    //gets the proper string from the map and returns its key or null depending on if its in the map
    @Override
    public Integer get(String name){
      return map.get(name);
    }

    //constructor for the hashmap aList
    public HashMapWords() {
        map = new HashMap<String, Integer>();
    }
}
