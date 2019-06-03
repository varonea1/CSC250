public class Test2 {
    public static void main(String [] args) {
        AVLTree temp = new AVLTree();

        temp.insert("12", "a");
        temp.insert("10", "b");
        temp.insert("09", "c");
        temp.insert("08", "d");
        temp.insert("06", "d");
        temp.insert("04", "d");
        temp.insert("02", "d");
        temp.insert("02", "d");

        temp.print();
        System.out.println("insert 07 ");
        temp.insert("07", "d");
        temp.print();
        System.out.println("Delete 12, 10, 09 06");
        temp.deleteNode("12");
        temp.deleteNode("10");
        temp.deleteNode("09");
        temp.deleteNode("06");
        temp.print();
        temp.levelOrder();
    }
}
