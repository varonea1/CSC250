import java.util.*;

public class AVLTree {
    // fields
    private AVLNode root;

    // constructor
    public AVLTree() {
        root = null;
    }

    // return AVLTree root
    public AVLNode getRoot() {
        return root;
    }

    // search value ss in the AVL tree
    public boolean find(String ss) {
        if (root == null) {
            return false;
        }

        AVLNode node = root;

        while (node != null) {
            if (ss.compareTo(node.getSSN()) == 0) {
                return true;
            }
            if (ss.compareTo(node.getSSN()) < 0) {
                node = node.getLeft();
            }
            else {
                node = node.getRight();
            }
        }
        return false;
    }

    // return the height of the subtree rooted at node
    // if subtree is empty, height is -1
    // if subtree has one node, height is 0
    public int height(AVLNode node) {

        if(node != null) {
            return node.getHeight();
        }
        else {
            return -1;
        }
    }

    // return the balance factor of the node
    private int balanceFactor(AVLNode node) {
        return height(node.getLeft()) - height(node.getRight());
    }

    // update the height of the node
    // this should be done whenever the tree is modified
    private void updateHeight(AVLNode node) {
        int hl = height(node.getLeft());
        int hr = height(node.getRight());
        node.setHeight((hl > hr ? hl : hr) + 1);
    }

    // rotate right the subtree rooted at node
    // return the new root of the subtree
    private AVLNode rotateRight(AVLNode node) {
        AVLNode lp = node.getLeft();     // left child of node
        if (node.getParent() != null) {  // node is not root
            if (node.getParent().getLeft() == node) { // node is a left child
                node.getParent().setLeft(lp);
            }
            else {
                node.getParent().setRight(lp);     // node is a right child
            }
        }

        if (lp.getRight() != null) {           // pointer update
            lp.getRight().setParent(node);
        }

        lp.setParent(node.getParent());
        node.setLeft(lp.getRight());
        lp.setRight(node);
        node.setParent(lp);
        updateHeight(node);                   // after rotation, update height
        updateHeight(lp);                     // after rotation, update height
        if (node == root) {
            root = lp;
        }
        return lp; // lp is the new root of the subtree
    }

    // rotate left the subtree rooted at node
    // return the new root of the subtree
    private AVLNode rotateLeft(AVLNode node) {
        AVLNode rp = node.getRight();
        if (node.getParent() != null) {
            if (node.getParent().getLeft() == node) {
                node.getParent().setLeft(rp);
            }
            else {
                node.getParent().setRight(rp);
            }
        }

        if (rp.getLeft() != null) {
           rp.getLeft().setParent(node);
        }

        rp.setParent(node.getParent());

        node.setRight(rp.getLeft());
        rp.setLeft(node);
        //node.setParent(rp);
        node.setParent(rp);
        updateHeight(node);
        updateHeight(rp);
        if (node == root) {
            root = rp;
        }
        return rp;
    }

    // rebalance a tree rooted at node
    // return the new root of the subtree
    private AVLNode balance(AVLNode node) {
        updateHeight(node);
        if (balanceFactor(node) == 2) {
            if (balanceFactor(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft())); // for left right case
            }
            AVLNode temp = rotateRight(node);
            updateHeight(temp);
            return temp;
        }

        if (balanceFactor(node) == -2) {
            if (balanceFactor(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));  // for right left case
            }
            AVLNode temp2 = rotateLeft(node);
            updateHeight(temp2);
            return temp2;
        }
        return node;
    }

    // insert a new node with (ss, na) to the AVL tree
    // if there exists ss value, return false
    // otherwise, insert it, balance the tree, return true
    public boolean insert(String ss, String na) {
    /*  if(this.find(ss)) {
        return false;
      }*/

      AVLNode newNode = new AVLNode(ss, na);
      if(this.root == null) {
        this.root = newNode;
        newNode.setParent(null);
        return true;
      }
      AVLNode curr = root;
      while (curr != null) {
        if(Integer.parseInt(newNode.getSSN()) < Integer.parseInt(curr.getSSN())) {
          if(curr.getLeft() == null) {
            curr.setLeft(newNode);
            newNode.setParent(curr);
            curr = null;
          }
          else {
            curr = curr.getLeft();
          }
        }
        else {
          if(curr.getRight() == null) {
            curr.setRight(newNode);
            newNode.setParent(curr);
            curr = null;
          }
          else {
            curr = curr.getRight();
          }
        }
      }

      newNode = newNode.getParent();
      while(newNode != null) {
        balance(newNode);
        newNode = newNode.getParent();
      }
      return true;
    }

    private AVLNode maxOfSubtree(AVLNode node ){
        if (node == null) {
            return null;
        }
        node = node.getLeft();
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    // delete the node containing value ss
    // if there is not such node, return false
    // otherwise, delete the node, balance the tree, return true
    public boolean deleteNode(String ss) {

      if(root == null) {
        return false;
      }

      if(this.find(ss) == false) {
        return false;
      }

      AVLNode deleteNode;
      AVLNode check = root;
      AVLNode parent = null;

      while(root != null) {
        if(ss.compareTo(check.getSSN()) == 0) {
          break;
        }
        if(ss.compareTo(check.getSSN()) < 0) {
          check = check.getLeft();
        }
        else {
          check = check.getRight();
        }
      }
      deleteNode = check;

      parent = deleteNode.getParent();

      //case 1: the node to be deleted is a leaf
      if(deleteNode.getLeft() == null && deleteNode.getRight() == null) {
        if(deleteNode == root) {
          root = null;
          return true;
        }
        else {
          if(parent.getSSN().compareTo(deleteNode.getSSN()) < 0) {
            parent.setRight(null);
            deleteNode = null;
          }
          else {
            parent.setRight(null);
          }
        }
        return true;
      }

      //case 2: there is either a left child or right child
      else if(deleteNode.getLeft() != null ^ deleteNode.getRight() != null) {
        if(deleteNode == root) {
          if(deleteNode.getLeft() != null) {
            root = deleteNode.getLeft();
            root.setParent(null);
          }
          else {
            root = deleteNode.getRight();
            root.setParent(null);
          }
        }
        else {
          //left child
          if(deleteNode.getLeft() != null) {
            //left child of parent
            if(deleteNode.getParent().getSSN().compareTo(deleteNode.getLeft().getSSN()) > 0) {
              deleteNode.getParent().setLeft(deleteNode.getLeft());
            }
            //right child of parent
            else{
              deleteNode.getParent().setRight(deleteNode.getLeft());
            }
          }
          //right child
          else {
            //left child of parent
            if(deleteNode.getParent().getSSN().compareTo(deleteNode.getRight().getSSN()) > 0) {
              deleteNode.getParent().setLeft(deleteNode.getRight());
            }
            //right child of parent
            else {
              deleteNode.getParent().setRight(deleteNode.getRight());
            }
          }
        }
      }

      //case 3: there are two children
      else {
        AVLNode maxVal = maxOfSubtree(deleteNode);
        AVLNode action = maxVal.getParent();
        AVLNode leftChild = maxVal.getLeft();

        parent = action;

        deleteNode.setSSN(maxVal.getSSN());
        deleteNode.setName(maxVal.getName());

        if(leftChild != null) {
          leftChild.setParent(action);
          if(action.getLeft() == maxVal) {
            action.setLeft(leftChild);
          }
          else {
            action.setRight(leftChild);
          }
        }
        else {
          if(action.getLeft() == maxVal) {
            action.setLeft(null);
          }
          else {
            action.setRight(null);
          }
        }
        maxVal = null;
      }
      AVLNode current = parent;
      while(current != null) {
        balance(current);
        current = current.getParent();
      }
      return true;
    }

    // pseudo-setw() from C++
    private void setw(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print(' ');
        }
    }

    // internal function
    // do not call it directly
    private void print(AVLNode x, int indent) {
        if(x == null)
            return;

        if (x.getRight() != null) {
            print(x.getRight(), indent + 4);
        }

        if (indent != 0) {
            setw(indent);
        }

        if(x.getRight() != null) {
            System.out.print(" /\n");
            setw(indent);
        }

        System.out.println(x.getSSN());

        if (x.getLeft() != null) {
            setw(indent);
            System.out.print(" \\\n");
            print(x.getLeft(), indent + 4);
        }
    }

    // print out the structure of the binary tree
    // use it for debugging, I love this function
    public void print() {
        int count = 0;
        print(root, count);
    }

    // perform a level-order traversal and
    // print the number of nodes in the tree
    // use it mainly for debugging
    public void levelOrder() {
        int counter = 0;
        Queue<AVLNode> queue = new ArrayDeque<AVLNode>();

        //pushes the root onto the queue
        if(root != null) {
          queue.offer(root);
        }

        //sets temp to the top of the queue, prints it and then removes it
        while(queue.peek() != null) {
          AVLNode temp = queue.peek();
          queue.poll();

          //adds the left side first and then the right side to the queue
          if(temp.getLeft() != null) {
            queue.offer(temp.getLeft());
          }

          if(temp.getRight() != null) {
            queue.offer(temp.getRight());
          }
          counter++;
        }

        System.out.println("tree size: " + counter);
    }
}
