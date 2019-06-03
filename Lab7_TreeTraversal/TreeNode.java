/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Lab 7
*
*  The file contains the class that creates the treeNode object.  Each tree node contains a datum value as well as a
pointer to the left tree node datum value and the right tree node datum value.  Additionally there are accessors and mutators for
the datum and the left and right node.
********************************************************/

public class TreeNode {
    // Tree Node has data, left pointer, right pointer
    int datum;
    TreeNode left;
    TreeNode right;

    // create a new TreeNode with given value; left and right pointers are null
    public TreeNode(int value) {
        this.datum = value;
        this.left = null;
        this.right = null;
    }

    // accessor/mutator methods
    public int getDatum() {
        return this.datum;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setDatum(int datum) {
        this.datum = datum;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
