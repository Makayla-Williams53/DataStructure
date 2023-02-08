public class Main {
    public static void main(String[] args)
    {
        Tree myTree = new Tree();

        myTree.addRoot(0);

        System.out.println("Root");
        myTree.printInOrder(myTree.getRoot());

        myTree.addRow();
        System.out.println("\nRow 1");
        myTree.printInOrder(myTree.getRoot());

        myTree.addRow();
        System.out.println("\nRow 2");
        myTree.printInOrder(myTree.getRoot());

        myTree.addRow();
        System.out.println("\nRow 3");
        myTree.printInOrder(myTree.getRoot());
    }


}