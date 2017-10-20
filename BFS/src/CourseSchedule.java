import java.util.*;
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses == 0){
            return true;
        }
        if (prerequisites.length == 0){
            return true;
        }

        HashMap<Integer, HashSet<Integer>> graph = initializeGraph(numCourses, prerequisites);

        //count in-degree
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            for (Integer pre: graph.get(i)){
                if (indegree.containsKey(pre)){
                    indegree.put(pre, indegree.get(pre) + 1);
                } else {
                    indegree.put(pre, 1);
                }
            }
        }
        //topological soring - bfs

        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < numCourses; i++){
            if(!indegree.containsKey(i)){
                queue.offer(i);
                result.add(i);
            }
        }

        while(!queue.isEmpty()){
            int head = queue.poll();
            for(Integer pre: graph.get(head)){
                indegree.put(pre, indegree.get(pre) - 1);
                if(indegree.get(pre) == 0){
                    result.add(pre);
                    queue.offer(pre);
                }
            }
        }
        //canFinish - result.size == numCourse
        if(result.size() == numCourses){
            return true;
        }
        return false;
    }

    private HashMap<Integer, HashSet<Integer>> initializeGraph(int numCourses, int[][] prerequisites){
        HashMap<Integer,HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++){
            map.put(i, new HashSet<>());
        }

        for (int j = 0; j < prerequisites.length; j++){
            int u = prerequisites[j][0];
            int v = prerequisites[j][1];
            map.get(v).add(u);
        }

        return map;
    }
}
