import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 */
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        if (n == 0) {
            return false;
        }
        //because there is no duplicate edges. So n - 1 == edges.length is the condition of tree;
        if (n - 1 != edges.length) {
            return false;
        }

        //initialize graph
        HashMap<Integer, HashSet<Integer>> graph = initializeGraph(n, edges);
        //then, we need to make sure all the node connected through traverse graph by BFS
        // BFS
        //queue to store all nodes of each level
        Queue<Integer> queue = new LinkedList<>();
        //Nodes can be traversed from start node
        HashSet<Integer> traversedNodeSet = new HashSet<>();

        //add all start nodes
        queue.offer(0);
        traversedNodeSet.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (traversedNodeSet.contains(neighbor)) {
                    continue;
                }
                traversedNodeSet.add(neighbor);
                queue.add(neighbor);
            }
        }
        return (traversedNodeSet.size() == n);
    }

    private HashMap<Integer,HashSet<Integer>> initializeGraph(int n, int[][] edges) {
        HashMap<Integer,HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.put(i, new HashSet<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }
}
