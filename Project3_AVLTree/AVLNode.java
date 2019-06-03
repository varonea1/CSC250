/********************************************************
*  Name      : Adam Varone
*  Course    : CSC 250-01
*  Date      : Spring 2019
*  Professor : DeGood
*
*  Assignment: Project 3
*
*This class contains the node object.  It has all of the getters and setters for the left child, right child, parent, name, and ssn
********************************************************/

public class AVLNode {
    // private fields
    private String ssn;
    private String name;
    private AVLNode left;
    private AVLNode right;
    private AVLNode parent;
    private int height;

    public AVLNode(String ss, String na) {
        ssn = ss;
        name = na;
        left = null;
        right = null;
        parent = null;
        height = 0;
    }

    // accessor and mutator methods
    public String getSSN() {
        return this.ssn;
    }

    public String getName() {
        return this.name;
    }

    public AVLNode getLeft() {
        return this.left;
    }

    public AVLNode getRight() {
        return this.right;
    }

    public AVLNode getParent() {
        return this.parent;
    }

    public int getHeight() {
        return this.height;
    }

    public void setSSN(String ssn) {
        this.ssn = ssn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public void setParent(AVLNode parent) {
        this.parent = parent;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
