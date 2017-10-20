import java.util.*;
/*
Given a binary tree, return the zigzag level order traversal of its nodes' values.
(ie, from left to right, then right to left for the next level and alternate between).
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7


return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
 */
//Key point: ArrayList.add(0, element)!!! Or Collections.reverse()
public class BinaryTreeZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Boolean leftToRight = true;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode head = queue.poll();

                if (leftToRight){
                    level.add(head.val);
                } else {
                    level.add(0, head.val);
                }
                if (head.left != null){
                    queue.offer(head.left);
                }
                if (head.right != null){
                    queue.offer(head.right);
                }
            }
            leftToRight = !leftToRight;
            result.add(level);
        }

        return result;
    }
}
