public class FlattenTree {
//    public void flatten(TreeNode root) {
//        TreeNode node = helper(root);
//        //System.out.println("helper return value: " + node.val);
//        print(root);
//
//    }
    public void print(TreeNode root){
        while(root != null){
            System.out.print(root.val + "->");
            root = root.right;
        }
        System.out.println();
    }
    private TreeNode helper(TreeNode root){


        if(root == null){
            System.out.println("get null node!");
            return null;
        }
        System.out.println("Enter:" + root.val);
        TreeNode leftLast = helper(root.left);
        System.out.print(root.val + " leftLast: ");
        System.out.println(leftLast == null? "null":leftLast.val);
        TreeNode rightLast = helper(root.right);
        System.out.print(root.val + " rightLast: ");
        System.out.println(rightLast == null? "null":rightLast.val);
        System.out.println();

        if(leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            print(root);
        }



        if(leftLast != null){
            return leftLast;
        }
        if(rightLast != null){
            return rightLast;
        }
        System.out.println("Because no children, return root node: " + root.val);
        System.out.println();
        return root;
    }

    TreeNode pre=null;
    public void flatten1(TreeNode root) {
        if(root==null)
            return ;
        System.out.println(root.val);
        flatten1(root.right);
        flatten1(root.left);

        root.left=null;
        root.right=pre;
        pre=root;

    }
    public static void main(String[] args){
        FlattenTree test = new FlattenTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        TreeNode node2 = root.left;
        node2.left = new TreeNode(3);
        node2.right = new TreeNode(4);
        node2.left.left = new TreeNode(5);

//        test.flatten(root);
        test.flatten1(root);

    }
}
