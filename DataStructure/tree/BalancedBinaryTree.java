public class BalancedBinaryTree {

    public class ResultType {
        boolean isBalanced;
        int maxDepth;

        ResultType(boolean isBalanced, int maxDepth) {
            this.isBalanced = isBalanced;
            this.maxDepth = maxDepth;
        }
    }

    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.isBalanced;
    }

    private ResultType helper(TreeNode node) {

        if (node == null) {
            return new ResultType(true, 0);
        }

        ResultType left = helper(node.left);
        ResultType right = helper(node.right);

        if (left.isBalanced == false || right.isBalanced == false) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new ResultType(false, -1);
        }


        return new ResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }

    public static void main(String[] args){
        BalancedBinaryTree test = new BalancedBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node2 = root.left;
        TreeNode node3 = root.right;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);

        boolean isBalanced = test.isBalanced(root);
        System.out.println(isBalanced);
    }
}

