class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int arr[][] = new int[m][n];
        // int dis = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i,j});
                    vis[i][j] = true;
                    arr[i][j] = 0;
                }                
            }
        }
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int r = curr[0];
            int c = curr[1];
            int neighbour[][] = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1} };
            for(int neigh[] : neighbour){
                int nr = neigh[0];
                int nc = neigh[1];
                    // dis = 0;
                if(nr<0 || nc<0 || nr>=m || nc>=n || vis[nr][nc] == true) continue;
                vis[nr][nc] = true;
                arr[nr][nc] = arr[r][c] +1;
                q.add(new int[] {nr,nc});
            }
        }
        return arr;
    }
}
                  
            
                
            