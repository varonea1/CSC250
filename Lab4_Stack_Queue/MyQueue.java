/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 4
*
*  This class creates the queue the is made of two stacks.  It contains three methods
a top which returns the top of the stack.  A push method which adds to the stack and a pop method
which removes from the top of the stack.
********************************************************/

import java.util.Stack;

public class MyQueue<T> {
    // define two private instance variables
    private Stack<T> first;
    private Stack<T> second;

    //constructor creates two new stacks
    public MyQueue() {
      first = new Stack<T>();
      second = new Stack<T>();
    }
    // return the value of the oldest member depending on which stack contains the values
    public T top() {
      if(first.empty()) {
        return second.peek();
      }
      else {
        return first.peek();
      }
    }

    // add value val to MyQueue
    public void push(T val) {
      //if both stacks arew empty adds to the first stack
      if(first.empty() && second.empty()) {
        first.push(val);
      }
      //if the second stack is empty adds to the first stack and moves values to the second stack
      else if(second.empty()) {
        first.push(val);
        while(! first.empty()) {
          second.push(first.peek());
          first.pop();
        }
      }

      //otherwise moves the values from the second stack to the first then adds the new value
      else {
        while(! second.empty()) {
          first.push(second.peek());
          second.pop();
        }
        first.push(val);

        while(! first.empty()) {
          second.push(first.peek());
          first.pop();
        }
      }
    }

    // remove the oldest member from MyQueue depending on which stack has the values
    public void pop() {
      if(first.empty()) {
        second.pop();
      }
      else {
        first.pop();
      }
    }
}
