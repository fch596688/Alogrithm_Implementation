import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
    Design an algorithm and write code to serialize and deserialize a binary tree.
    Writing the tree to a file is called 'serialization'
    and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
    An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:

      3
     / \
    9  20
      /  \
     15   7
    Our data serialization use bfs traversal.
    This is just for when you got wrong answer and want to debug the input.

    You can use other method to do serializaiton and deserialization.

 */

//Key point: tree bfs and string <-> tree
public class BinaryTreeSerialization {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */

    public String serialize(TreeNode root){
        ArrayList<TreeNode> nodes  = new ArrayList<>();
        if(root == null){
            return "{}";
        }

        //BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(head == null){
                //if node == null, we just the null value, because it doesn't children. We don't have to
                //add children into the queue for next-level traverse.
                nodes.add(null);
                continue;
            }
            nodes.add(head);
            queue.add(head.left);
            queue.offer(head.right);
        }


        //this caters the lintcode output requirement to remove all null node
        while(nodes.get(nodes.size() - 1) == null){
            nodes.remove(nodes.size() -1);
        }


        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(root.val + "");
        for (int i = 1; i < nodes.size(); i++){
            if (nodes.get(i) == null){
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(nodes.get(i).val);
            }
        }
        sb.append("}");

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }

        String [] values = data.substring(1, data.length() - 1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for (int i = 1; i < values.length; i++){
            TreeNode parent  = queue.poll();
            if (!values[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                parent.left = node;
                queue.offer(parent.left);
            }

            i++;

            if(i < values.length){
                if (!values[i].equals("#")){
                    TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = node;
                    queue.offer(parent.right);
                }
            }
        }

        return root;
    }

    public static void main(String[] args){
        BinaryTreeSerialization obj = new BinaryTreeSerialization();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
        String resultS = obj.serialize(root);
        System.out.println(resultS);
        TreeNode result = obj.deserialize(resultS);
        String resultAS = obj.serialize(root);
        System.out.println(resultAS);
    }
}
