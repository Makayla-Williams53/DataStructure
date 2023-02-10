public class Main {
    public static void main(String[] args)
    {
        //creates tree
        Tree myTree = new Tree();

        //adds root
        myTree.addRoot(0);
        System.out.println("Root");
        myTree.printInOrder(myTree.getRoot());

        //adds a row
        myTree.addRow();
        System.out.println("\nRow 1");
        myTree.printInOrder(myTree.getRoot());

        //adds a row
        myTree.addRow();
        System.out.println("\nRow 2");
        myTree.printInOrder(myTree.getRoot());

        //adds a row
        myTree.addRow();
        System.out.println("\nRow 3");
        myTree.printInOrder(myTree.getRoot());

        //adds a row
        myTree.addRow();
        System.out.println("\nRow 4");
        myTree.printInOrder(myTree.getRoot());

        myTree.deleteRow();
        System.out.println("\nDeleted Row");
        myTree.printInOrder(myTree.getRoot());
    }


}