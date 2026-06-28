class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0 || i==m-1 || j==n-1){
                    if(grid[i][j] == 1){
                        q.add(new int[] {i,j});
                        vis[i][j] = true; 
                    }
                }
            }
        }
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int neighbour[][] = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1} } ;
            for(int neigh[] : neighbour){
                int nr = neigh[0];
                int nc = neigh[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n ||vis[nr][nc] || grid[nr][nc] != 1) continue;
                vis[nr][nc] = true;
                q.add(new int[] {nr,nc});

            }
        }
        int count = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if((grid[i][j] == 1) && (vis[i][j] == false)){
                    count++;
                } 
            }
        }
        return count;
    }
}