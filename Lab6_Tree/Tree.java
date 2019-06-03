/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 6
*
*  This file contains all of the methods that interact with the tree.  This class includes
methods to insert new nodes, search for a node, check if a node is a leaf, calculate the number of
nodes in the tree, calculate the height of the tree, and print out the tree.
********************************************************/

import java.lang.Math;

public class Tree<V> {
    TreeNode<V> root;
    int size;

    // default constructor
    // by default, the tree is empty
    public Tree() {
        root = null;
        size = 0;
    }

    // search value x in tree rooted at node t
    public boolean treeSearch(V x, TreeNode<V> t) {
        //if the tree is empty then the node won't be found
        if(t == null)
            return false;
        if(t.getDatum() == x)
            return true;
        return treeSearch(x, t.getLeft()) || treeSearch(x, t.getRight());
    }

    public boolean treeSearch(V x) {
        return treeSearch(x, root);
    }


    // binary search value x in tree rooted at node t
    public boolean treeBSearch(V x, TreeNode<V> t) {
        //ceates a temp node thats datum is the node you are searching for
        TreeNode<V> temp = new TreeNode<V>(x);
        //sets the node curr to the root
        TreeNode<V> curr = t;
        while(curr != null) {
          //if the root is the node searched for returns true
          if((int) curr.getDatum() == (int) temp.getDatum()) {
            return true;
          }
          //else travers the left side of the tree and the right side until the value is found
          else if((int) curr.getDatum() > (int) temp.getDatum()) {
            curr = curr.getLeft();
          }
          else {
            curr = curr.getRight();
          }
        }
        //if the whole tree is traversed without finding the value, false is returned
        return false;
    }

    public boolean treeBSearch(V x) {
        return treeBSearch(x, root);
    }

    // check node t is leaf
    public boolean isLeaf(TreeNode<V> t) {
      //if both childs are null then the node is a leaf
      if(t.getLeft() == null && t.getRight() == null) {
        return true;
      }
      else {
        return false;
      }
    }

    // find the height of the tree rooted at node t
    public int height(TreeNode<V> t) {
        int leftHeight;
        int rightHeight;
        int max;
        //base case
        if(t == null) {
          return -1;
        }
        //recursive case
        else {
          leftHeight = height(t.getLeft()); //gets the height of each level of the tree
          rightHeight = height(t.getRight());
          return (1 + Math.max(leftHeight, rightHeight)); //returns the max height value
        }
    }

    public int height() {
        return height(root);
    }

    // find the number of nodes of tree rooted at t
    public int nNodes(TreeNode<V> t) {
        //base case
        if(t == null) {
          return 0;
        }
        //recursive case
        else {
          //each time a node is found one more value gets returned. The initial one is for the root
            return 1 + nNodes(t.getLeft()) + nNodes(t.getRight());
          }
    }

    public int nNodes() {
        return nNodes(root);
    }


    // insert value x to the current tree object
    public void insert(V x) {
      TreeNode<V> temp = new TreeNode<V>(x);
      //if the tree is empty the new node becomes the root
      if(root == null) {
        root = temp;
        size++;
      }

      else {
        TreeNode<V> curr = root;
        while(true) {
          //goes to the left child
          if((int) x < (int) curr.getDatum()) {
            //if there is no left child the new node becomes the left child
            if(curr.getLeft() == null) {
              curr.setLeft(temp);
              size++;
              return;
            }
            //traverse until an empty left child is found
            else {
              curr = curr.getLeft();
            }
          }
          //same algorithm as the left side of the tree but used for the right side
          else {
            if(curr.getRight() == null) {
              curr.setRight(temp);
              size++;
              return;
            }
            else {
              curr = curr.getRight();
            }
          }
        }
      }
    }

    private void setw(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(' ');
        }
    }

    // print out the values of tree rooted at x
    // it shows the hierarchy of the tree
    // it will be useful for debugging
    public void print(TreeNode<V> x, int indent) {
        if(x == null) return;
        if (x.getRight() != null) {
            print(x.getRight(), indent + 4);
        }

        if (indent != 0) {
            setw(indent);
        }

        if(x.getRight() != null){
            System.out.print(" /\n");
            setw(indent);
        }

        System.out.println(x.getDatum());

        if (x.getLeft() != null) {
            setw(indent);
            System.out.print(" \\\n");
            print(x.getLeft(), indent + 4);
        }
    }

    public void print() {
        int count = 0;
        print(root, count);
    }

};
