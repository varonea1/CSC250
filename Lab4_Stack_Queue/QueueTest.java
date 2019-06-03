/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 4
*
*  This class is used to test the queue the was made using two stacks.  First it pushes
three names onto the stack.  Then it prints the top name pops it off and repeats.
********************************************************/

public class QueueTest {
    public static void main (String[] args) {
      MyQueue <String> names = new MyQueue<String>(); /* Declare a MyQueue */
      names.push ("Liz"); /* add values to the end of the MyQueue */
      names.push ("John");
      names.push ("Mike");

      System.out.println("Serve the people in queue: ");
      System.out.println(names.top());
      names.pop();
      System.out.println(names.top());
      names.pop();
      System.out.println(names.top());
      names.pop();
  }
}
