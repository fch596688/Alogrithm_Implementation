import java.util.*;
public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {


        HashMap<Integer, HashSet<Integer>> graph = initializeGraph(numCourses, prerequisites);

        HashMap<Integer, Integer> indegree = new HashMap<>();

        for(int i = 0; i < numCourses; i++){
            for(Integer pre: graph.get(i)){
                if (indegree.containsKey(pre)){
                    indegree.put(pre, indegree.get(pre) + 1);
                } else {
                    indegree.put(pre, 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList();
        int[] findOrder = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++){
            if(!indegree.containsKey(i)){
                queue.offer(i);
                findOrder[index++] = i;
            }
        }

        while(!queue.isEmpty()){
            int head = queue.poll();
            for(Integer pre: graph.get(head)){
                indegree.put(pre, indegree.get(pre) - 1);
                if(indegree.get(pre) == 0){
                    queue.offer(pre);
                    findOrder[index++] = pre;
                }
            }
        }

        if(findOrder.length == graph.size()){
            return findOrder;
        }

        return new int[]{};
    }

    private HashMap<Integer, HashSet<Integer>> initializeGraph(int numCourses, int[][] prerequisites){
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new HashSet<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(v).add(u);
        }
        return graph;
    }

    public static void main(String[] args){
        CourseSchedule2 obj = new CourseSchedule2();
        int[][] pre = {{1,0},{2,0},{3,1},{3,2}};
        String str = Arrays.toString(obj.findOrder(4, pre));
        System.out.println(str);
    }
}
