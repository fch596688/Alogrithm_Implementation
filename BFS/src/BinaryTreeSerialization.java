import java.util.ArrayList;

public class BinaryTreeSerialization {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null){
            return "{}";
        }
        //1. put all the start node into queue;

        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        //2. poll node from queue,
        for (int i = 0; i < queue.size(); i++){
            TreeNode head = queue.get(i);
            if(head == null){
                continue;
            }
            //3. put all node in next level into queue;
            queue.add(head.left);
            queue.add(head.right);
        }

        while (queue.get(queue.size() - 1) == null){
            queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(root.val);

        for (int j = 1; j < queue.size(); j++){
            if (queue.get(j) == null){
                sb.append(",#");
            } else {
                sb.append(",");
                sb.append(queue.get(j).val);
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

        String[] values = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        int rootIndex = 0;
        boolean isLeftChildren = true;

        for (int i = 1; i < values.length; i++){
            if (!values[i].equals("#")){
                TreeNode node = new TreeNode(Integer.parseInt(values[i]));
                if (isLeftChildren){
                    queue.get(rootIndex).left = node;
                } else {
                    queue.get(rootIndex).right = node;
                }
                queue.add(node);
            }

            if(!isLeftChildren){
                rootIndex++;
            }


            isLeftChildren = !isLeftChildren;
        }

        return root;
    }

    public static void main(String[] args){
        BinaryTreeSerialization obj = new BinaryTreeSerialization();
        TreeNode result = obj.deserialize("{}");
        System.out.println(result);
    }
}
