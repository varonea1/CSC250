/********************************************************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 7.22
*
*  This class contains the object type ItemToPurchase.  ItemToPurchase has paramaters name, price, quantity,
and description.  It allows the user to get or set any of these values.  Additionally there are methods to
output a single item cost, a single item description or the total cost.
********************************************************************************************/

public class ItemToPurchase{

  private String itemName;
  private int itemPrice;
  private int itemQuantity;
  private String itemDescription;

  //Constructor that sets the paramaters to initial values.
  public ItemToPurchase(){
    itemName = "none";
    itemPrice = 0;
    itemQuantity = 0;
    itemDescription = "none";
  }

  //Paramaterized constructor to set the name, description, price, and quantity to inputed values.
  public ItemToPurchase(String itemName, String itemDescription, int itemPrice, int itemQuantity){
    this.itemName = itemName;
    this.itemPrice = itemPrice;
    this.itemQuantity = itemQuantity;
    this.itemDescription = itemDescription;
  }

  //Method to print the cost of an item.
  public void printItemCost(){
    System.out.println(getName() + " " + getQuantity() + " @ $" + getPrice() + " = $" + totalCost());
  }

  //Method to print the description of an item.
  public void printItemDescription(){
      System.out.println(getName() + ": " + getDescription());
  }

  //Method to print the total cost of an item.
  public int totalCost(){
    int total = 0;
    total = (getPrice() * getQuantity());
    return total;
  }

  //Sets description.
  public void setDescription(String description){
    itemDescription = description;
  }

  //Sets name.
  public void setName(String name){
    itemName = name;
  }

  //Sets price.
  public void setPrice(int price){
    itemPrice = price;
  }

  //Sets quantity.
  public void setQuantity(int quantity){
    itemQuantity = quantity;
  }

  //Gets description.
  public String getDescription(){
      return itemDescription;
  }

  //Gets name.
  public String getName(){
      return itemName;
  }

  //Gets price.
  public int getPrice(){
    return itemPrice;
  }

  //Gets quantity.
  public int getQuantity(){
    return itemQuantity;
  }
}
