/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 7.22
*
*  This class includes the functionallity for the shopping cart itself.  It has a name date and
an arraylist of cart items.  It contains the methods that the shopping cart manager calls
to update the shopping cart.
********************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart{

  private String customerName;
  private String currentDate;
  private ArrayList<ItemToPurchase> cartItems = new ArrayList<>();

  //Construtor that initializes the customer name and date.
  public ShoppingCart(){
    customerName = "none";
    currentDate = "January 1, 2016";
  }

  //Paramaterized constructor that allows the user to create a shopping cart with paramaters.
  public ShoppingCart(String customerName, String currentDate){
    this.customerName = customerName;
    this.currentDate = currentDate;
  }

  //Adds item to shopping cart of type ItemToPurchase.
  public void addItem(ItemToPurchase item){
    cartItems.add(item);
  }

  //Removes an item from the shopping cart, uses a string as a parameter to find the item to remove.
  public void removeItem(String itemToRemove){
   //Boolean expression initially set false and then set true if the removeItem is found.
   boolean execution = false;

   //For loop that creates a new object of type ItemToPurchase and traverses through the array list.
   for(ItemToPurchase itemToPurchase : cartItems){
     //If statement that compares the name of the newley created object and the object passed through the initial method.
      if(itemToPurchase.getName().equalsIgnoreCase(itemToRemove)){
        //If the statement is true it removes the item.
        cartItems.remove(itemToPurchase);
        execution = true;
        break;
      }
    }
    if(!execution){
      System.out.println("Item not found in cart. Nothing removed." + "\n");
    }
  }

  //Function for the modify item case.
  public void modifyItem(ItemToPurchase itemToChange){
    //First check if there are items in the cart.
    if(cartItems.size() != 0){
      //For loop that creates a new object of type ItemToPurchase and traverses through the array list.
      for(ItemToPurchase itemToPurchase : cartItems){
        //If the name of the newly created object is the same as the name of the object created in the
        //ShoppingCartManager class then the quantity is changed of the object in the for loop.
        if(itemToPurchase.getName().equalsIgnoreCase(itemToChange.getName())){
          itemToPurchase.setQuantity(itemToChange.getQuantity());
          break;
        }
        else{
          System.out.println("Item not found in cart. Nothing modified." + "\n");
          break;
        }
      }
    }
    else{
      System.out.println("The cart is empty.");
    }
  }

  //Method to get the number of items in the cart.
  public int getNumItemsInCart(){
    int numItems = 0;

    //Traverses throught the cart and adds the quantity of the current objec to the int numItems.
    for(ItemToPurchase itemToPurchase : cartItems){
      numItems += itemToPurchase.getQuantity();
    }
    return numItems;
  }

  //Method to get the total cost of the cart.
  public int getCostOfCart(){
    int cost = 0;

    //For loop that traverses through  cartitems, grabs the current item in the cart and then finds the total cost of it.
    for(int i = 0; i < cartItems.size(); i++){
      cost += cartItems.get(i).totalCost();
    }
    return cost;
  }

  //Method to print the name and date of the person using the shopping cart, the number of items, and the total cost of cart,
  public void printTotal(){
    System.out.println("OUTPUT SHOPPING CART");
    System.out.println(customerName + "'s Shopping Cart - " + currentDate);
    System.out.println("Number of Items: " + getNumItemsInCart() + "\n");

    //Checks if the cart is empty and notifies the user if it is.
    if(cartItems.size() == 0){
      System.out.println("SHOPPING CART IS EMPTY");
      System.out.println("\n" + "Total: $" + getCostOfCart() + "\n");
    }

    //If there are items in the cart, traverses through the cart and calls the print item cost method for each item.
    else{
      for(ItemToPurchase itemToPurchase : cartItems){
        itemToPurchase.printItemCost();
      }
      System.out.println("\n" + "Total: $" + getCostOfCart() + "\n");
    }
  }

  //Method to print the descriptions of the items.
  public void printDescriptions(){
    System.out.println(customerName + "'s Shopping Cart - " + currentDate + "\n" + "\n" + "Item Descriptions");
    for(ItemToPurchase itemToPurchase : cartItems){
      itemToPurchase.printItemDescription();
    }
  }

  //Method to get the customer name.
  public String getCustomerName(){
      return customerName;
  }

  //Method to get the date.
  public String getDate(){
      return currentDate;
  }
}
