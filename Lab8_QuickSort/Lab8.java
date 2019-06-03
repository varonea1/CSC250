/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 8
*
*  This class creates a sorts an array using the quicksort data structure.  First a file is read into an array using fileByteStream.
There is a partition method that partitions the array into two groups where one groups values are all less than the other group.
The quicksort method calls the partition method and then usues recursion to continuously sort the array.  Finally main prints
out the sorted array.
********************************************************/

import java.io.*;
import java.util.Scanner;

public class Lab8 {

    // quick sort function
    static void quickSort(int arr[], int left, int right) {
        int c = 0;

        //base case
        //if there are 1 or zero elements then the partition is sorted
        if(left >= right) {
          return;
        }

        //partition the array and assign it to c
        c = partition(arr, left, right);

        //recursively sort the low and high partitions
        quickSort(arr, left, c);
        quickSort(arr, c + 1, right);
    }

    static int partition(int arr[], int left, int right) {
      int a = 0;
      int b = 0;
      int midpoint = 0;
      int pivot = 0;
      int temp = 0;
      boolean done = false;

      //picks the middle value as the midpoint
      midpoint = left + (right - left) / 2;
      //uses the midpoint to pick the pivot point
      pivot = arr[midpoint];

      a = left;
      b = right;

      while(!done) {
        //increments a while numbers at index a is less than pivot
        while(arr[a] < pivot) {
          ++a;
        }
        //decrements b while pivot is less than index b
        while(pivot < arr[b]) {
          --b;
        }

        //if there are one or zero items left then the partition is done and b is returned
        if(a >= b) {
          done = true;
        }

        //swap arr[a] and arr[b] and update a and b
        else {
          temp = arr[a];
          arr[a] = arr[b];
          arr[b] = temp;
          ++a;
          --b;
        }
      }
      return b;
    }

    public static void main(String [] args) {
        Scanner scnr = new Scanner(System.in);
        //creates a new file which is the file inputted on the command line
        File myFile = new File(args[0]);
        FileInputStream fileByteStream = null;
        Scanner in = null;
        //creates an array of size 5000
        int[] vals = new int[5000];
        //counter to determine how many values are put into the array
        int counter = 0;

        try {
          int i = 0;
          //creates file input stream and opens the myFile that was created earlier
          fileByteStream = new FileInputStream(myFile);
          //The FileInputStream class only supports a basic byte stream, thus this creates a new scanner object using fileByteStream
          in = new Scanner(fileByteStream);

          //While there is still a next line in myFile
          while(in.hasNextLine()) {
            //gets rid of all spaces in the file and creates a new String
            String[] input = in.nextLine().split("\\s+");
            //creates a new string called test which is the string on each line of the inputted file
            String test = input[0];
            int result = Integer.parseInt(test);
            counter++;
            vals[i] = result;
            i++;
          }
        }

        catch (FileNotFoundException ex) {
          System.out.println("Did not find file");
        }

        //calls the quicksort method on the array
        quickSort(vals, 0, counter - 1);

        System.out.println("Quick Sort Result is: ");

        //prints the sorted array
        for(int k = 0; k < counter; k++) {
          System.out.println(vals[k]);
        }
    }
}
