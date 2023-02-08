
public class Tree
{
    //variables
    private TreeNode root;

    //constructor
    public Tree()
    {
        root = null;
    }



    private class TreeNode
    {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int x)
        {
            value = x;
            left = null;
            right = null;
        }//end constructor TreeNode
    }//end class TreeNode
}
