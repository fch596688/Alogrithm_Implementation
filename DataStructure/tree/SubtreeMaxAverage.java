public class SubtreeMaxAverage {
    private class ResultType{
        int sum;
        int size;
        public ResultType(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }
    private TreeNode subTree;
    private ResultType subTreeResult;

    public TreeNode findSubtreeWithMaxAverage(TreeNode root){
        helper(root);
        return subTree;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0,0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        System.out.println("root:" + root.val);

        int sumRoot = left.sum + right.sum + root.val;
        System.out.println("sum:" + sumRoot);
        int size = left.size + right.size + 1;
        System.out.println("size:" + size);
        System.out.println();


        ResultType result = new ResultType(sumRoot, size);

        if(subTree == null || sumRoot * subTreeResult.size > subTreeResult.sum * size){
            subTree = root;
            subTreeResult = result;
        }

        return result;

    }

    public static void main(String[] args){
        SubtreeMaxAverage test = new SubtreeMaxAverage();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode node2 = root.left;
        TreeNode node3 = root.right;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);

        TreeNode subtree = test.findSubtreeWithMaxAverage(root);
        System.out.println(subtree.val);
    }
}
