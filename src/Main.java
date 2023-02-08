public class Main {
    public static void main(String[] args)
    {
        Tree myTree = new Tree();

        myTree.addRoot(45);

        myTree.printInOrder(myTree.getRoot());
    }


}