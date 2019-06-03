/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Project 2
*
* This class creates the SLL list object.  It has methods insert, search, remove, get size, and display
THis SLL is used when a collision occurs in a bucket of the hashtable.
********************************************************/

public class SLL {
    Node headPtr;
    int size;

    // default constructor
    public SLL() {
        this.headPtr = null;
        this.size = 0;
    }
    //getter for the head pointer
    public Node getHeadPtr() {
        return headPtr;
    }

    // insert (item1, item2) at the SLL head
    public void insert(String item1, String item2) {
        Node newNode = new Node();
        newNode.SSN = item1;
        newNode.name = item2;

        //inserts at head if the SLL is empty
        if(headPtr == null)  {
          headPtr = newNode;
          size++;
        }

        //else puts the new node at the head
        else {
          Node temp = headPtr;
          headPtr = newNode;
          newNode.next = temp;
          size++;
        }
    }

    // if find the item1 key
    // then return the node
    // else return null
    public Node search(String item1) {
        Node temp = headPtr;
        while (temp != null) {
          if(temp.SSN.equals(item1)) {
            return temp;
          }
          temp = temp.next;
        }
        return null;
    }

    // if find the item1 key
    // then remove the node and return true
    // else return false
    public boolean remove(String item1) {
      //if the head is the SSN to remove then it gets removed
      if(headPtr.SSN.equals(item1)) {
        headPtr = headPtr.next;
        size--;
        return true;
      }

      //this statement is used if only one node is in the SLL
      else if(headPtr.next == null) {
        headPtr = null;
        size--;
        return true;
      }

      //This statement travers through the list until the next node is the one to be deleted
      else {
        Node temp = headPtr;
        while(temp.next != null) {
          if(temp.next.SSN.equals(item1)) {
            temp.next = temp.next.next;
            size--;
            return true;
          }
          temp = temp.next;
        }
        return false;
      }
    }

    public int getSize() {
        return size;
    }

    // display the SSN and name values of each node in the linked list
    public void display() {
        Node temp;
        temp = headPtr;
        while (temp != null) {
            System.out.println(temp.SSN + ":" + temp.name);
            temp = temp.next;
        }
    }
}
