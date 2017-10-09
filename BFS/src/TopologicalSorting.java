import java.util.*;

public class TopologicalSorting {
    class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
    };
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {

        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        //1. count in-degree, the in-degree of start node will be 0 and map doesn't contain that node.
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for(DirectedGraphNode node: graph){
            for(DirectedGraphNode neighbor: node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor, map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }

        //2. bfs - find the start node
        Queue<DirectedGraphNode> queue = new LinkedList<>();


        for(DirectedGraphNode node: graph){
            if(!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }

        while(!queue.isEmpty()){
            DirectedGraphNode head = queue.poll();
            for(DirectedGraphNode neighbor: head.neighbors){
                map.put(neighbor, map.get(neighbor) -1);
                if(map.get(neighbor)  == 0){
                    result.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        if(result.size() == graph.size()){
            return result;
        }

        return null;
    }
}
