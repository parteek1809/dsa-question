// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int n = graph.length;
//         ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
//         for(int i=0;i<n;i++){
//             rev.add(new ArrayList<>());
//         }
//         int indeg[] = new int[n];
//         for(int i=0;i<n;i++){    //reverse
//             indeg[i] = graph[i].length;
//             for(int it : graph[i]){
//                 rev.get(it).add(i);
//             }
//         }
//         Queue<Integer> q = new LinkedList<>();
//         for(int i=0;i<n;i++){
//             if(indeg[i] == 0){
//                 q.add(i);
//             }
//         }
//         List<Integer> res = new ArrayList<>();
//         while(!q.isEmpty()){
//             int curr = q.poll();
//             res.add(curr);
//             for(int neigh : rev.get(curr)){
//                 indeg[neigh]--;
//                 if(indeg[neigh] == 0){
//                     q.add(neigh);
//                 }
//             }
//         }
//         Collections.sort(res);
//         return res;
//     }
// }


class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;
        int[] state = new int[n];
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            if(dfs(graph, i, state)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {

        // Already known safe
        if(state[node] == 2)
            return true;

        // Found a cycle
        if(state[node] == 1)
            return false;

        // Mark as visiting
        state[node] = 1;

        for(int neigh : graph[node]) {

            if(!dfs(graph, neigh, state)) {
                return false;
            }
        }

        // Safe node
        state[node] = 2;

        return true;
    }
}