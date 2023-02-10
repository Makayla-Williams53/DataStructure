import java.util.LinkedList;
import java.util.Queue;

public class Tree
{
    //variables
    private TreeNode root;
    private final Queue<TreeNode> queue = new LinkedList<>();
    private int i = 0;
    private int depth = 0;
    private int size;
    private int count = 1;
    //set a new count variable for the different nodes
    private int newCount = 1;
    //boolean for search method
    private final static boolean found = false;

    //constructor
    public Tree()
    {
        root = null;
    }//end constructor Tree

    public TreeNode getRoot()
    {
        return root;
    }//end getRoot

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
                    node.left = new TreeNode(count);
                    count++;
                    //add right child
                    node.right = new TreeNode(count);
                    count++;

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
                    node.left = new TreeNode(newCount);
                    newCount++;
                    node.right = new TreeNode(newCount);
                    newCount++;

                    //add node left and node right to queue
                    newQueue.add(node.left);
                    newQueue.add(node.right);
                }//end for loop
            }//end else
        }//end while loop

        //set the original root to the newly created one
        root = newRoot;
    }//end deleteRow

    //takes the results from the searchNode and puts it into printed sentences
    public void searchNodeTest(TreeNode node, int x)
    {
        //if found
        if(searchNode(node, x))
        {
            System.out.println("Value was found within the tree");
        }//end if
        else
        {
            System.out.println("Value was not found within the tree");
        }//end else
    }//end searchNodeTest

    public boolean searchNode(TreeNode node, int x)
    {
        //if the tree is empty print out empty
        if(root == null)
        {
            System.out.println("Tree is empty");
        }//end if
        else
        {
            //if the value is that node return true
            if(node.value == x)
            {
                return true;
            }//end inner if
            //if not found search left node
            if(!found && node.left != null)
            {
                searchNode(node.left, x);
            }//end second inner if
            //if not found search right node
            if(!found && node.right != null)
            {
                searchNode(node.right, x);
            }//end third inner if
        }//end else

        //return found var
        return found;
    }//end searchNode

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


    private static class TreeNode
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
