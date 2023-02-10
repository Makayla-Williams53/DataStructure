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

    //The only way my brain could figure out how to delete a row
    //was to create a new node with one less row, then set root to row
    public void deleteRow()
    {
        //set a depth with a value 2 less than the original depth
        int newDepth = depth - 2;
        //if the new depth is zero return a null node
        if(newDepth == 0);
        {
            root = null;
        }//end if
        //create a new node
        Queue<TreeNode> newQueue = new LinkedList<>();
        //create a new i variable
        int newi = 0;

        //crate a new root node and add it to the queue
        TreeNode newRoot = new TreeNode(0);
        newQueue.add(newRoot);

        //while queue isn't empty fill the tree
        while(!newQueue.isEmpty())
        {
            //create a new size variable to hold the new queue size
            int newSize = newQueue.size();
            //increase new i by 1
            newi++;
            //if the newi is greater than the newdepth break
            if(newi > newDepth)
            {
                break;
            }//end if
            else
            {
                //for when j is less than new size crate new nodes for the left and right branches
                for(int j = 0; j < newSize; j++)
                {
                    //set a current node to the first one in the queue and remove it from the queue
                    TreeNode node = newQueue.remove();
                    node.left = new TreeNode(newi);
                    node.right = new TreeNode(newi);

                    //add node left and node right to queue
                    newQueue.add(node.left);
                    newQueue.add(node.right);
                }//end for loop
            }//end else
        }//end while loop

        //set the original root to the newly created one
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
