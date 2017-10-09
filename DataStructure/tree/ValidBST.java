public class ValidBST {
    class ReturnType{
        private boolean isBST;
        private int maxValue;
        private int minValue;
        public ReturnType(boolean isBST, int maxValue, int minValue){
            this.isBST = isBST;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    public boolean isValidBST(TreeNode root) {
        ReturnType result = helper(root);
        return result.isBST;
    }

    private ReturnType helper(TreeNode root){
        System.out.println("enter");
        if (root == null){
            return new ReturnType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        System.out.println(root.left);
        ReturnType left = helper(root.left);
        System.out.println(root.right);
        ReturnType right = helper(root.right);
        if(left.isBST == false || right.isBST == false){
            return new ReturnType(false, 0, 0);
        }

        if(root.left != null && left.maxValue >= root.val || root.right != null && right.minValue <= root.val){
            return new ReturnType(false, 0, 0);
        }

        return new ReturnType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
    }

    public static void main(String[] args){
        ValidBST test = new ValidBST();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(1);
//        root.right= new TreeNode(3);
//        boolean result = test.isValidBST(root);
//        System.out.println(result);
    }
}
