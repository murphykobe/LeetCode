// There are a total of n courses you have to take, labeled from 0 to n-1.
//
// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
//
// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
//
// Example 1:
//
//
// Input: 2, [[1,0]] 
// Output: true
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0. So it is possible.
//
// Example 2:
//
//
// Input: 2, [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0, and to take course 0 you should
//              also have finished course 1. So it is impossible.
//
//
// Note:
//
//
// 	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// 	You may assume that there are no duplicate edges in the input prerequisites.
//
//


class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses==0 || prerequisites.length==0 || prerequisites==null) return true;
        
        List<List<Integer>> graph = new ArrayList<List<Integer>>(numCourses);
        
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] visited = new int[numCourses];
        
        for(int i=0;i<numCourses;i++){
            if(dfs(graph,i,visited)){
                return false;
            }
        }
        return true;
    }
    
    public boolean dfs(List<List<Integer>> graph, int course, int[] visited){
        
        if (visited[course] == 1) return true;
        if (visited[course] == 2) return false;
        
        visited[course]=1;
        
        List<Integer> temp=graph.get(course);
        
        for(int i=0;i<temp.size();i++){
            int j=temp.get(i).intValue();
            if(dfs(graph,j,visited))return true;
        }
        visited[course]=2;
        return false;
    }
}
