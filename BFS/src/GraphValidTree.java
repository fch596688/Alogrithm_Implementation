import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * Example Given n = 2, prerequisites = [[1,0]]
 * Return [0,1]
 * Given n = 4, prerequisites = [1,0],[2,0],[3,1],[3,2]]
 * Return [0,1,2,3] or [0,2,1,3]
 */
//Key point: initialize graph and graph bfs,
// tree: 1. n - 1 == edges.length
//       2. we can traverse from root node to all nodes
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
        // BFS-graph
        //queue to store all nodes of each level
        Queue<Integer> queue = new LinkedList<>();
        //Nodes can be traversed from start node
        HashSet<Integer> traversedNodeSet = new HashSet<>();

        //add all start nodes
        queue.offer(0);
        traversedNodeSet.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            //neighbors are actually nodes in next level
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
