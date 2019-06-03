/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 3
*
*  This class contains the object of the actual linked list.  The linked list contains
a list of nodes.  This class has two methods, one is the insert method that inserts nodes
in order of their SSN.  The other method is a search method that searches for a SSN based on
a user input.
********************************************************/

public class LinkedList {
  private Node head;
  private Node tail;

  //Constructor that sets head and tail initally to null
  public LinkedList() {
    this.head = null;
    this.tail = null;
  }

  //Method to insert a node in cronological order.
  public void insert(Node newNode) {
    //Converts the passed through node to an integer and assigns it to intNewNode
    int intNewNode = Integer.parseInt(newNode.getSocial());

    //If the linked list is empty the newNode will become the head
    if(head == null) {
      head = newNode;
    }

    //If there is only one node in the list will insert a new node in either the first or second location
    else if(head.getNext() == null) {
      int newHead = Integer.parseInt(head.getSocial());
      //if head is smaller than the new node the new node will be inserted after head
      if(newHead < intNewNode) {
        head.setNext(newNode);
      }
      else {
        Node temp = head;
        head = newNode;
        newNode.setNext(temp);
      }
    }

    //This statement checks if the newnode needs to be inserted at the very beginning of the list
    else if(Integer.parseInt(head.getSocial()) > intNewNode) {
      Node temp = head;
      head = newNode;
      newNode.setNext(temp);
    }

    //Covers all other cases of insertion
    else {
      Node temp = head;
      int newTemp = Integer.parseInt(temp.getNext().getSocial());
      //Parses through the list until the new node is greater than the node next to it or it needs to be added to the end of the list
      while((newTemp < intNewNode) && (temp.getNext().getNext() != null)) {
        temp = temp.getNext();
        //resets newTemp to the next node and converts it from a string to an int
        newTemp = Integer.parseInt(temp.getNext().getSocial());
      }

      //Once it is determined where the node needs to be entered this if/else has two possible scenarios
      //The first case is when the node is inserted into the middle of the list
      //The else part is when the node is inserted at the end of the list
      if(newTemp > intNewNode) {
        Node temp2 = temp.getNext();
        temp.setNext(newNode);
        newNode.setNext(temp2);
      }
      else {
        temp.getNext().setNext(newNode);
      }
    }
  }

  //Method to print the list
  public void printList() {
    Node temp = head;
    //Parses through the list and prints the social and each node
    while(temp != null) {
      System.out.println(temp.getSocial());
      temp = temp.getNext();
    }
  }

  //Method that searches for a particular SSN in a node
  public int search(String SSN) {
    Node temp = head;
    int counter = 0; //counter is used to determine the index of where the node is in the list
    //Parses through list if social equals the passed through social the index(counter) is returned else the counter increases
    while(temp != null) {
      if(temp.getSocial().equals(SSN)) {
        return counter;
      }
      temp = temp.getNext();
      counter++;
    }
    //If the while loop reaches null without them equaling it returns -1
    return -1;
  }
}
