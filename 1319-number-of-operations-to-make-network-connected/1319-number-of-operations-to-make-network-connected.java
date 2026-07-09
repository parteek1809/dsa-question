class Disjoint{
    int parent[];
    int size[];
    public Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int node){
        if(node == parent[node]) return node;
        return parent[node] = find(parent[node]);
    }
    public boolean union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa == pb) return false;
        if(size[pa] < size[pb]){
            parent[pa] = pb;
            size[pb] += size[pa];
        }
        else{
            parent[pb] = pa;
            size[pa] += size[pb];
        }
        return true;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int extra = 0;
        for(int edge[] : connections){
            if(!ds.union(edge[0], edge[1])){
                extra++;
            }
        }
        int component = 0;
        for(int i=0; i<n; i++){
            if(ds.find(i) == i){
                component++;
            }
        }
        int need = component -1;
        if(extra >= need) return need;
        return -1;
    }
}







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


