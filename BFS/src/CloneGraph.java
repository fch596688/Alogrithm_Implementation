import java.util.*;
//key point: graph-bfs, copy node, copy edges
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }
        //1. find all nodes - bfs
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> traversedNode = new HashSet<>();
        queue.offer(node);
        traversedNode.add(node);

        while(!queue.isEmpty()){
            UndirectedGraphNode head = queue.poll();
            for(UndirectedGraphNode neighbor: head.neighbors){
                if(traversedNode.contains(neighbor)){
                    continue;
                }
                traversedNode.add(neighbor);
                queue.offer(neighbor);
            }
        }
        //2. clone all nodes
        HashMap<UndirectedGraphNode,UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode oldNode: traversedNode){
            UndirectedGraphNode newNode = new UndirectedGraphNode(oldNode.label);
            mapping.put(oldNode, newNode);
        }
        //3. clone all edges
        for(UndirectedGraphNode oldNode: traversedNode){
            for(UndirectedGraphNode neighbor: oldNode.neighbors){
                //Getting new neighbor must be from mapping relationship.
                //map stores all relationship between old nodes and new nodes.
                //if adding the neighbors of old node or creating neighbor with old neighbor's label
                //there would have reference error.
                mapping.get(oldNode).neighbors.add(mapping.get(neighbor));
            }
        }

        return mapping.get(node);
    }

    public static void main(String[] args){
        CloneGraph obj = new CloneGraph();
        UndirectedGraphNode node = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(0);
        node.neighbors.add(node1);
        node.neighbors.add(node2);
        UndirectedGraphNode newNode = obj.cloneGraph(node);
        System.out.println(newNode.label);
        for(UndirectedGraphNode node123: newNode.neighbors){
            System.out.println(node123.label);
        }
    }
}
