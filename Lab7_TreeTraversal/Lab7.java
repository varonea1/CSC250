/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 7
*
*  The file contains the driver class for the program.  First it has a method that usues a stack to print out the values
of the tree in order.  The next method uses a queue to print out the values in level order.  Finally main creates
the tree and calls the two methods mentioned above.
********************************************************/

import java.util.*;

public class Lab7 {

    // Non-recursive traverse a binary tree
    // print out the values by inorder
    // it uses stack to store the nodes
    static void noRecInorder(TreeNode root) {
      //creates a new stack of type TreeNode
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(true) {
          //pushes the left subtree of a node to the stack
          while(root != null) {
            stack.push(root);
            root = root.getLeft();
          }
          //breaks when the tree is done being traversed
          if(stack.empty()) {
            break;
          }
          //pops the node, prints the value of the node, and pushes the right subtree of the stack
          root = (stack.peek());
          stack.pop();
          System.out.println(root.getDatum());
          root = root.getRight();


        }
    }

    // Non-recursive level-order traversal
    // It uses queue to store the values of the next level
    static void levelOrder(TreeNode root) {
      Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

      //pushes the root onto the queue
      if(root != null) {
        queue.offer(root);
      }

      //sets temp to the top of the queue, prints it and then removes it
      while(queue.peek() != null) {
        TreeNode temp = queue.peek();
        System.out.println(temp.getDatum());
        queue.poll();

        //adds the left side first and then the right side to the queue
        if(temp.getLeft() != null) {
          queue.offer(temp.getLeft());
        }

        if(temp.getRight() != null) {
          queue.offer(temp.getRight());
        }
      }

    }


    // Driver program to test above functions
    public static void main(String args[]) {
        /* Constructed binary tree is
                100
              /     \
              9      10
             /  \    /
             9   4  7
        */
        TreeNode root = new TreeNode(100);
        root.setLeft(new TreeNode(9));
        root.setRight(new TreeNode(10));
        root.getLeft().setLeft(new TreeNode(9));
        root.getLeft().setRight(new TreeNode(4));
        root.getRight().setLeft(new TreeNode(7));

        System.out.println("Inorder traversal result:");
        noRecInorder(root);

        System.out.println("Level traversal result:");
        levelOrder(root);
    }
}
