/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 3
*
*  This class contains the main method that calls the other objects.
********************************************************/

import java.util.Scanner;
import java.io.*;

public class Lab3 {

  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    LinkedList list = new LinkedList();

    FileInputStream fileByteStream = null;
    Scanner in = null;

    try{
      //creates file input stream and opens the sample.txt file
      fileByteStream = new FileInputStream("sample.txt");
      //The FileInputStream class only supports a basic byte stream, thus this creates a new scanner object using fileByteStream
      in = new Scanner(fileByteStream);

      //While there is still a next line in sample.txt
      while(in.hasNextLine()){
        //gets rid of all spaces in the file
        String[] input = in.nextLine().split("\\s+");
        //since there is an i which would be spot input[0] the social is location input[1]
        String newSocial = input[1];
        //newname is the next two non space locations with a space added in between
        String newName = input[2] + " " + input [3];
        //a new node is created for each line and inserted into the linked list
        Node newNode = new Node(newSocial, newName);
        list.insert(newNode);
      }
    }

    //a check to make sure the file is actually found
    catch (FileNotFoundException ex) {
      System.out.println("Did not find file");
    }

    //Scans in the user input of a SSN and calls the search method to see if its in the list and prints the proper index followed by the list
    System.out.println("Input a SSN:");
    String SSN = scnr.nextLine();
    int index = list.search(SSN);
    System.out.println("Found at: " + index + "\n" + "List contents:");
    list.printList();
  }
}
