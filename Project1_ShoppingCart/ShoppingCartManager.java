/****************************************************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 7.22
*
*  This class contains main and manages the entire shopping cart.  It will first create a new cart
with a header containing the shoppers name and the current date.  It will then print out a menu
which will allow the user to add items to the shopping cart, remove items, change item quantities,
output item descriptions, and finally output the whole shopping cart.
*****************************************************************************************/

import java.util.Scanner;

public class ShoppingCartManager{

  /*
  Main method that creates a new shopping cart with the user name and current date.  It will then
  run the printMenu method with the newlsy created shopping cart as a paramater.
  */
  public static void main(String[] args){
    Scanner scnr = new Scanner(System.in);
    System.out.println("Enter Customer's Name:");
    String custName = scnr.nextLine();

    System.out.println("Enter Today's Date:");
    String todayDate = scnr.nextLine();

    ShoppingCart cart = new ShoppingCart(custName, todayDate);
    System.out.println("\n" + "Customer Name: " + custName + "\n" + "Today's Date: " + todayDate + "\n");
    printMenu(cart, scnr);
  }

  /*
  Print the menu and takes in the user inputted character to determine which function to run.  Continuously
  outputs the menu and runs the desired function until the user inputs q to terminate the program.
  */
  public static void printMenu(ShoppingCart cartToPrint, Scanner scnr2){
    //Boolean value that will always stay true unless user inputs q which causes the program to exit.
    Boolean systemStatus = true;
    //This char is defined at the end of each case statement.  It is used to reset the menuSelection to a variable
    //that will allow the loop to exit and not cause an infinite loop.
    char menuSelection = 'x';
    System.out.println("MENU" + "\n" + "a - Add item to cart" + "\n" + "d - Remove item from cart" + "\n" + "c - Change item quantity" + "\n" + "i - Output items' descriptions" + "\n" + "o - Output shopping cart" + "\n" + "q - Quit" + "\n" + "\n" + "Choose an option:" );
    menuSelection = scnr2.nextLine().charAt(0);

    while(systemStatus){

      switch(menuSelection){
        //Case to print the item list.
        case 'o':
          cartToPrint.printTotal();
          menuSelection = 'x';
          System.out.println("MENU" + "\n" + "a - Add item to cart" + "\n" + "d - Remove item from cart" + "\n" + "c - Change item quantity" + "\n" + "i - Output items' descriptions" + "\n" + "o - Output shopping cart" + "\n" + "q - Quit" + "\n");
          break;

        //Case to print the item descriptions.
        case 'i' :
          System.out.println("OUTPUT ITEMS' DESCRIPTIONS");
          cartToPrint.printDescriptions();
          System.out.println();
          menuSelection = 'x';

          System.out.println("MENU" + "\n" + "a - Add item to cart" + "\n" + "d - Remove item from cart" + "\n" + "c - Change item quantity" + "\n" + "i - Output items' descriptions" + "\n" + "o - Output shopping cart" + "\n" + "q - Quit" + "\n");
          break;

        //Case to add an item to the list.
        case 'a' :
          String itemNameInput;
          String itemDescriptionInput;
          int itemPriceInput;
          int itemQuantityInput;

          //Gets the name, description price and quantity for the new item to be added.
          System.out.println("ADD ITEM TO CART" + "\n" + "Enter the item name:");
          itemNameInput = scnr2.nextLine();

          System.out.println("Enter the item description:");
          itemDescriptionInput = scnr2.nextLine();

          System.out.println("Enter the item price:");
          itemPriceInput = scnr2.nextInt();
          scnr2.nextLine();

          System.out.println("Enter the item quantity:");
          itemQuantityInput = scnr2.nextInt();

          System.out.println();
          //Scans the next line so the next scanner will start on the next line
          scnr2.nextLine();

          //Creates the new item of type ItemToPurchase and adds it to the cart.
          ItemToPurchase newItem = new ItemToPurchase(itemNameInput, itemDescriptionInput, itemPriceInput, itemQuantityInput);
          cartToPrint.addItem(newItem);
          System.out.println("MENU" + "\n" + "a - Add item to cart" + "\n" + "d - Remove item from cart" + "\n" + "c - Change item quantity" + "\n" + "i - Output items' descriptions" + "\n" + "o - Output shopping cart" + "\n" + "q - Quit" + "\n");
          menuSelection = 'x';
          break;

        //Case to remove an item from the cart.
        case 'd' :
          String nameToRemove;

          System.out.println("REMOVE ITEM FROM CART" + "\n" + "Enter name of item to remove:");
          nameToRemove = scnr2.nextLine();
          cartToPrint.removeItem(nameToRemove);
          menuSelection = 'x';
          System.out.println("MENU" + "\n" + "a - Add item to cart" + "\n" + "d - Remove item from cart" + "\n" + "c - Change item quantity" + "\n" + "i - Output items' descriptions" + "\n" + "o - Output shopping cart" + "\n" + "q - Quit" + "\n");
          break;

        //Case to change the quantity of an item in the list.
        case 'c' :
          String nameToModify;
          int quantityToModify;

          System.out.println("CHANGE ITEM QUANTITY" + "\n" + "Enter the item name:");
          nameToModify = scnr2.nextLine();

          System.out.println("Enter the new quantity:");
          quantityToModify = scnr2.nextInt();
          scnr2.nextLine();

          //Creates a new object of type ItemToPurchase.  This is needed to be passed into the
          //modifyItem method and compare the name of the object while parsing through the shopping cart.
          ItemToPurchase quantityToChange = new ItemToPurchase(nameToModify, "none", 0, quantityToModify);
          cartToPrint.modifyItem(quantityToChange);
          System.out.println("MENU" + "\n" + "a - Add item to cart" + "\n" + "d - Remove item from cart" + "\n" + "c - Change item quantity" + "\n" + "i - Output items' descriptions" + "\n" + "o - Output shopping cart" + "\n" + "q - Quit" + "\n");
          menuSelection = 'x';
          break;

        //Case to quit the program.
        case 'q' :
          //Sets the boolean value to false which will cause the while loop to exit and the program to exit.
          systemStatus = false;
          break;

        default :
          System.out.println("Choose an option:");
          menuSelection = scnr2.nextLine().charAt(0);
          break;
      }
    }
    System.exit(0);
  }
}
