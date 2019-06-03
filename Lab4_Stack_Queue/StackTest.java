/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 4
*
*  This class is used to test the stack the was made using two queues.  First it pushes
three names onto the stack.  Then it prints the top name pops it off and repeats.
********************************************************/

public class StackTest {
    public static void main (String[] args)
    {
      MyStack <String> names = new MyStack<String>(); /* Declare a MyQueue */
      names.push ("Liz"); /* add values to the end of the MyQueue */
      names.push ("John");
      names.push ("Mike");

      System.out.println("Serve the people in queue: ");
      //Print the name on the top of the stack
      System.out.println(names.top());
      names.pop();
      System.out.println(names.top());
      names.pop();
      System.out.println(names.top());
      names.pop();
    }
}
