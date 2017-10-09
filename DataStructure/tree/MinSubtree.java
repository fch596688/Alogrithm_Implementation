public class MinSubtree {
    private TreeNode subTree;
    private int sumSubtree = Integer.MAX_VALUE;
    public TreeNode findSubtree(TreeNode root){
        helper(root);
        return subTree;
    }

    private int helper(TreeNode root){

        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        int sum = root.val + left + right;
        if(sum < sumSubtree){
            sumSubtree = sum;
            subTree = root;
        }
        return sum;
    }

    public static void main(String[] args){
        MinSubtree test = new MinSubtree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node2 = root.left;
        TreeNode node3 = root.right;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);

        TreeNode subtree = test.findSubtree(root);
        System.out.println(subtree.val);
    }
}
