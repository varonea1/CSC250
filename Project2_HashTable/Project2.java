/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Project 2
*
*This is the driver class.  Frst it creates a new Hashtable and reads in a particular input file.
It parses the command, SSN, and name into a string array and then manipulates these values to do the correct method.
This class outputs the amount of times input, retrieve, and delete are used as well as the amount of nodes in the Hashtable
and the time it took to compile.
********************************************************/

import java.io.*;
import java.util.Scanner;

public class Project2 {

    public static void main(String [] args) {
      //starts a count for the run time
      long startTime = System.currentTimeMillis();
      //create a new hashtable with 10007 buckets
      HashTable newTable = new HashTable(10007);
      //initialize each counter
      int iCounter = 0;
      int rCounter = 0;
      int dCounter = 0;
      Scanner scnr = new Scanner(System.in);

      File myFile = new File(args[0]);
      FileInputStream fileByteStream = null;
      Scanner in = null;

      try {
        //creates file input stream and opens the myFile that was created earlier
        fileByteStream = new FileInputStream(myFile);
        //The FileInputStream class only supports a basic byte stream, thus this creates a new scanner object using fileByteStream
        in = new Scanner(fileByteStream);

        //While there is still a next line in myFile
        while(in.hasNextLine()) {
          //gets rid of all spaces in the file and creates a new String
          String[] input = in.nextLine().split("\\s+");
          //creates a new string called test which is the string on each line of the inputted file
          String inDelRet = input[0];
          String social = input[1];
          String name = input[2];

          //if i is detected and the SSN is not already in the hashtable it gets inserted
          if(inDelRet.equals("i")) {
            if(newTable.find(social) == false) {
              newTable.insert(social, name);
              iCounter++;
            }
          }

          if(inDelRet.equals("d")) {
            if(newTable.erase(social) == true) {
              dCounter++;
            }
          }

          if(inDelRet.equals("r")) {
            if(newTable.find(social) == true) {
              rCounter++;
            }

          }
      }
      System.out.println("The number of valid insertions: " + iCounter);
      System.out.println("The number of valid deletions: " + dCounter);
      System.out.println("The number of valid retrievals: " + rCounter);
      System.out.println("The number of items in the table: " + newTable.getSize());

    }
      //catch if the file is not found
      catch (FileNotFoundException ex) {
        System.out.println("Did not find file");
      }

      //ends the timer and converts it to seconds
      long endTime = System.currentTimeMillis();
      double totalTime = (endTime - startTime) / 1000.0;
      System.out.println("Time elapsed: " + totalTime);
    }

}
