class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int conn[] : connections){
            adj.get(conn[0]).add(conn[1]);
            adj.get(conn[1]).add(conn[0]);
        }
        boolean vis[] = new boolean[n];
        int component = 0;
        for(int i=0; i<n; i++){
            if(!vis[i]){
                component++;
                dfs(adj, vis, i);
            }
        }
        return component-1;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int i){
        vis[i] = true;
        for(int neigh : adj.get(i)){
            if(!vis[neigh]){
                dfs(adj, vis, neigh);
            }
        }
    }
}