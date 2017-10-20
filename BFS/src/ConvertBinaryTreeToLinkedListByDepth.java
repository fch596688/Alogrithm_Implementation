import java.util.*;
public class ConvertBinaryTreeToLinkedListByDepth {
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            ListNode dummyHead  = new ListNode(-1);
            ListNode listNode = dummyHead;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode head = queue.poll();
                if(head.left != null){
                    queue.offer(head.left);
                }

                if(head.right != null){
                    queue.offer(head.right);
                }
                listNode.next = new ListNode(head.val);
                listNode = listNode.next;
            }
            result.add(dummyHead.next);
        }
        return result;
    }
}
