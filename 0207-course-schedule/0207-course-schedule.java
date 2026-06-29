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

// Time Complexity - O(N + E)
// Space Complexity - O(2N)

// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         int N = prerequisites.length;
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for(int i = 0; i<numCourses; i++) {
//             ArrayList<Integer> sub = new ArrayList<>();
//             adj.add(sub);
//         }

//         for(int i = 0; i<N; i++) {
//             adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
//         }

//         int indegree[] = new int[numCourses];
//         for(int i = 0; i<numCourses; i++) {
//             for(int it : adj.get(i)) {
//                 indegree[it]++;
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i = 0; i<numCourses; i++) {
//             if(indegree[i] == 0) {
//                 q.offer(i);
//             }
//         }

//         List<Integer> ans = new ArrayList<>();

//         while(!q.isEmpty()) {
//             int node = q.poll();
//             ans.add(node);

//             for(int it: adj.get(node)) {
//                 indegree[it]--;
//                 if(indegree[it] == 0) {
//                     q.offer(it);
//                 }
//             }
//         }

//         if(ans.size() == numCourses) {
//             return true;
//         }
//         return false;
//     }
// }
