/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 6
*
*  This file describes the treeNode.  It has a getter and setter for datum, left child
and right child.  As well as two constructors to initialize the treeNode.
********************************************************/

public class TreeNode<T> {
    T datum;
    TreeNode<T> left, right;

    // constructor with datum value, left and right are null
    public TreeNode(T x) {
        datum = x;
        left = null;
        right = null;
    }
    // constructor with datum value, left and right values
    public TreeNode(T x, TreeNode<T> lft, TreeNode<T> rgt) {
        datum = x;
        left = lft;
        right = rgt;
    }

    // get datum value
    public T getDatum() {
        return datum;
    }

    // get left pointer
    public TreeNode<T> getLeft() {
        return left;
    }

    // get right pointer
    public TreeNode<T> getRight() {
        return right;
    }

    // set the left pointer
    public void setLeft(TreeNode<T> p) {
        left = p;
    }

    // set the right pointer
    public void setRight(TreeNode<T> p) {
        right = p;
    }

}
