/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 6
*
*  This file contains main and runs the program.  It creates a new tree inserts different nodes into it,
searches for nodes, and determines the amount of nodes in the tree.
********************************************************/

public class Test {

    public static void main(String [] args) {
        Tree<Integer> myTree = new Tree<Integer>();
        myTree.insert(5);
        myTree.insert(3);
        myTree.insert(2);
        myTree.insert(4);
        myTree.insert(8);
        myTree.insert(6);
        myTree.insert(7);
        myTree.insert(9);

        System.out.println(myTree.treeBSearch(9));
        System.out.println(myTree.treeBSearch(11));
        System.out.println(myTree.nNodes());

        System.out.println("The Tree Looks Like: ");
        myTree.print();

        Tree<Integer> myTree2 = new Tree<Integer>();
        myTree2.insert(4);
        myTree2.insert(2);
        myTree2.insert(1);
        myTree2.insert(3);

        myTree2.insert(7);
        myTree2.insert(5);

       // myTree2.print();
    }
}
