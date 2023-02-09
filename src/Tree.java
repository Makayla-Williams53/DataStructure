import java.util.LinkedList;
import java.util.Queue;

public class Tree
{
    //variables
    private TreeNode root;
    private Queue<TreeNode> queue = new LinkedList<>();
    private int i = 0;
    private int depth = 0;
    private int size;

    //constructor
    public Tree()
    {
        root = null;
    }//end constructor Tree

    public TreeNode getRoot()
    {
        return root;
    }//end getRoot

    public int getSize()
    {
        return depth;
    }

    //create root
    public void addRoot(int x)
    {
        root = new TreeNode(x);
        queue.add(root);
        depth++;
    }//end addRoot

    //add row
    public void addRow()
    {
        //variable to hold where i was at the start
        int tempi = i;

        while(!queue.isEmpty())
        {
            //create a variable size and set it to the size of queue
            size = queue.size();
            i++;
            //if i is greater than the height of the tree STOP
            if(i > depth)
            {
                //FIX LATER
                //I apologize in advance for this
                break;
            }//end if
            else
            {
                //create a left and right child
                for(int j = 0; j < size; j++)
                {
                    //remove the current node from the queue
                    TreeNode node = queue.remove();
                    //add left child
                    node.left = new TreeNode(i);
                    //add right child
                    node.right = new TreeNode(i);

                    //add the children to the queue
                    queue.add(node.left);
                    queue.add(node.right);
                }//end for loop
            }//end else
        }//end while loop

        //sets i back to increase by 1 from where it was at the start of the call
        i = tempi+1;
        //increases the depth by 1
        depth++;
    }//end addRow

    public void deleteRow()
    {
        int newDepth = depth--;
        if(depth == 0);
        {
            root = null;
        }//end if
        Queue<TreeNode> newQueue = new LinkedList<>();
        int newi = 0;

        TreeNode newRoot = new TreeNode(0);
        newQueue.add(root);

        while(!queue.isEmpty())
        {
            int newSize = newQueue.size();
            newi++;
            if(newi > newDepth)
            {
                break;
            }
            else
            {
                for(int j = 0; j < size; j++)
                {
                    TreeNode node = newQueue.remove();
                    node.left = new TreeNode(newi);
                    node.right = new TreeNode(newi);

                    newQueue.add(node.left);
                    newQueue.add(node.right);
                }//end for loop
            }//end else
        }//end while loop

        root = newRoot;
    }//end deleteRow

    //print out tree (goes left, root, then right)
    public void printInOrder(TreeNode node)
    {
        //if the node is null return nothing
        if(node == null)
        {
            return;
        }//end if
        //recursion to go the furthest left as possible
        printInOrder(node.left);
        //print out the value
        System.out.print(node.value + " ");
        //recursion to go the furthest right on the same level and do the same thing
        printInOrder(node.right);
    }//end printInOrder


    private class TreeNode
    {
        //creates variables
        public int value;
        public TreeNode left;
        public TreeNode right;

        //constructor
        public TreeNode(int x)
        {
            value = x;
            left = null;
            right = null;
        }//end constructor TreeNode
    }//end class TreeNode
}//end Tree class
