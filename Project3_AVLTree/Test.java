public class Test {
    public static void main(String [] args) {
        AVLTree temp = new AVLTree();

        temp.insert("11", "a");
        temp.insert("09", "b");
        temp.insert("14", "c");
        temp.insert("06", "d");
        temp.insert("08", "d");
        temp.insert("07", "d");
        temp.insert("04", "d");
        temp.insert("12", "d");
        temp.insert("22", "d");
        temp.insert("10", "d");
        temp.insert("18", "d");
        temp.insert("05", "d");


        temp.deleteNode("09");
        temp.deleteNode("04");
        temp.deleteNode("14");
        temp.deleteNode("06");

        temp.insert("05", "d");








        temp.levelOrder();

        temp.print();
    }
}
