class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] col = new int[graph.length];
        // for(int i=0; i<graph.length; i++){
        //     col[i] = -1;
        // }
        Arrays.fill(col,-1);
        for(int i=0;i<graph.length;i++){
            if(col[i] != -1) continue;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            col[i] = 1;
            while(!q.isEmpty()){
                int curr = q.remove();
                for(int j=0; j<graph[curr].length; j++){
                    int neigh = graph[curr][j];
                    if(col[neigh] == -1){
                        col[neigh] = 1 - col[curr];
                        q.add(neigh);
                    }
                    else if (col[neigh] == col[curr]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

class Solution {

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] color = new int[n];

        Arrays.fill(color, -1);

        for(int i = 0; i < n; i++) {

            if(color[i] == -1) {

                if(!dfs(graph, color, i, 0))
                    return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph,
                        int[] color,
                        int node,
                        int currColor) {

        color[node] = currColor;

        for(int neigh : graph[node]) {

            if(color[neigh] == -1) {

                if(!dfs(graph,
                        color,
                        neigh,
                        1 - currColor))
                    return false;
            }
            else if(color[neigh] == currColor) {
                return false;
            }
        }
        return true;
    }
}


