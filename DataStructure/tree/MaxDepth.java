/*
    lintcode 97 Maximum Depth of Binary Tree
    Given a binary tree, find its maximum depth.
    The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
    Example
    Given a binary tree as follow:
      1
     / \
    2   3
       / \
      4   5

    The max depth is 3;
 */

public class MaxDepth {
    //dc
    public int treeMaxDepth(TreeNode node){

        if (node == null){
            return 0;
        }

        int left = treeMaxDepth(node.left);
        int right = treeMaxDepth(node.right);

        return Math.max(left, right) + 1;
    }

    //traverse tree
    private int depth;
    private int maxDepth(TreeNode node){
        depth = 0;
        getDepth(node, 1);
        return depth;
    }
    private void getDepth(TreeNode node, int currentDepth){

        if (node == null){
            return;
        }

        if(depth < currentDepth){
            depth = currentDepth;
        }
        getDepth(node.left, currentDepth + 1);
        getDepth(node.right, currentDepth + 1);

    }

    public static void main(String[] args){
        MaxDepth test = new MaxDepth();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node2 = root.left;
        TreeNode node3 = root.right;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);

        int depth  = test.treeMaxDepth(root);
        //one node
        int depth1 = test.treeMaxDepth(new TreeNode(0));
        System.out.println(depth);
        System.out.println(depth1);
    }
}
