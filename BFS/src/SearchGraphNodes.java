import java.util.*;

//Key point: graph-bfs
public class SearchGraphNodes {

    public UndirectedGraphNode searchNodes(ArrayList<UndirectedGraphNode> graph,
                                           Map<UndirectedGraphNode, Integer> values,
                                           UndirectedGraphNode node,
                                           int target){

        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> traversedNodeSet = new HashSet<>();
        queue.offer(node);
        traversedNodeSet.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            if(values.get(head) == target){
                return head;
            }

            for(UndirectedGraphNode neighbor: head.neighbors){
                if(!traversedNodeSet.contains(neighbor)){
                    traversedNodeSet.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        return null;
    }
}
