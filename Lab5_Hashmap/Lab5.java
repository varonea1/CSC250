/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 5
*
*  This file takes in a list of strings in the command prompt.  It determines the hashcode
of each string it then places them in an arraylist based upon their hashcode mod 10007.  As each item
is placed in the arraylist it is compared to all of the other numbers and if they are the same a counter goes up by one.
The program finally outputs the number of items in the list as well as the number of collisions.
********************************************************/

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Lab5 {

  public static void main(String args[]) {
    Scanner scnr = new Scanner(System.in);
    //creates a new file which is the file inputted on the command line
    File myFile = new File(args[0]);
    FileInputStream fileByteStream = null;
    Scanner in = null;
    int collisions = 0;
    //creates a new arraylist called values
    ArrayList<Integer> values = new ArrayList<Integer>();

    try {
      //creates file input stream and opens the myFile that was created earlier
      fileByteStream = new FileInputStream(myFile);
      //The FileInputStream class only supports a basic byte stream, thus this creates a new scanner object using fileByteStream
      in = new Scanner(fileByteStream);

      //While there is still a next line in myFile
      while(in.hasNextLine()) {
        //gets rid of all spaces in the file and creates a new String
        String[] input = in.nextLine().split("\\s");
        //creates a new string called test which is the string on each line of the inputted file
        String test = input[0];

        //tests if the hashcode value is already in the list each time a new one is added
        if(values.contains(hashcode(test) % 10007)) {
          collisions++;
        }
        //adds the new hashcode value
        values.add(hashcode(test) % 10007);
      }
        System.out.println("Lines: " + values.size());
        System.out.println("Collisions: " + collisions);
    }

    catch (FileNotFoundException ex) {
      System.out.println("Did not find file");
    }
  }

  //method that determines the hashcode for a particular string
  public static int hashcode(String s) {
    int num = 0;
    //puts the string into a character array to be able to parse through it and get the ascii value of each char
    char[] arrStr = s.toCharArray();
    //parses through the string and utilizes the hashcode function
    for(int i = 0; i < s.length(); i++) {
      num += (arrStr[i]) * power(31, (s.length() - 1 - i));
    }
    return num;
  }

  //method to find the power since the math.pow function uses doubles and we need ints
  public static int power(int base, int exponent) {
    int result = 1;
    //anything to the power of 0 is 1
    if(exponent == 0) {
      return 1;
    }
    //else return the computed exponent value
    else {
      for(int i = exponent; i > 0; i--) {
        result = result * base;
      }
      return result;
    }
  }
}
