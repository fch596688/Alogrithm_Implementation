import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a binary tree, return the level order traversal of its nodes' values.
(ie, from left to right, level by level).
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

   return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]
 */
//Key point: level-traverse
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root){
        ArrayList<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        //BFS-Tree
        //create a queue data structure to store the nodes traversed from the start node
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //This question requires us to traversed the tree by level. So we need a for loop.
        while(!queue.isEmpty()){
            //store the values of each level
            List<Integer> level = new ArrayList<>();
            //level traverse
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                //put the children into the queue
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }

            result.add(level);
        }
        return result;
    }
}
