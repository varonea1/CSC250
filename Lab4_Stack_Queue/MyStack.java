/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 4
*
*  This class creates the stack the is made of two queues.  It contains three methods
a top which returns the top of the stack.  A push method which adds to the stack and a pop method
which removes from the top of the stack.
********************************************************/

import java.util.Queue;
import java.util.ArrayDeque;

public class MyStack<T> {
    // define two private instance variables
    private Queue <T> first;
    private Queue <T> second;

    //constructor creates two new queues implemented by an arraydeque
    public MyStack() {
      first = new ArrayDeque<T>();
      second = new ArrayDeque<T>();
    }

    // return the latest value of MyStack
    public T top() {
      return first.peek();
    }

    // add value val to MyStack
    public void push(T val) {

      //if both queues empty adds to the first one
      if((first.peek() == null) && (second.peek() == null)) {
        first.offer(val);
      }
      //otherwise adds to the second queue and puts the all of the values from the first queue onto the second queue
      else {
        second.offer(val);
        while(first.peek() != null) {
          second.offer(first.peek());
          first.poll();
        }
        //places the values back onto the first stack so they print in correct order
        while(second.peek() != null) {
          first.offer(second.peek());
          second.poll();
        }
      }
    }
    // remove the oldest value from MyStack
    public void pop(){
      first.poll();
    }
}
