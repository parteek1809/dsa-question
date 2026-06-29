class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int pre[] : prerequisites){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }
        boolean vis[] = new boolean[numCourses];
        boolean stack[] = new boolean[numCourses];
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(dfsCycle(graph, stack, vis, i)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfsCycle(ArrayList<ArrayList<Integer>> graph , boolean stack[] ,boolean vis[], int src){
        vis[src] = true;
        stack[src] = true;
        for(int neigh : graph.get(src)){
            if(stack[neigh]){
                return true;
            }
            else if(!vis[neigh]){
                if(dfsCycle(graph, stack, vis, neigh)){
                    return true;
                }
            }
        }
        stack[src] = false;
        return false;
    }
}