/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 3
*
*  This class creates the node object.  This object has two parts, once is the data which
contains a SSN and a name.  The other part is the next which points to the next node
in the linked list.
********************************************************/

public class Node {

  private String socialNumber;
  private String personName;
  private Node next;

  //Constructor to set the social and name for a new node
  public Node(String social, String name) {
    this.socialNumber = social;
    this.personName = name;
    this.next = null;
  }

  //Getter for next node
  public Node getNext() {
    return next;
  }

  //Setter for next node
  public void setNext(Node nxt) {
    next = nxt;
  }

  //Getter for the SSN
  public String getSocial() {
    return socialNumber;
  }

  //Setter to set the SSN
  public void setSocial(String numb) {
    socialNumber = numb;
  }

  //Getter for the name
  public String getName() {
    return personName;
  }

  //Setter for the name
  public void setName(String name) {
    personName = name;
  }
}
