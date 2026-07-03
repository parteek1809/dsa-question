class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1; // edge case
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0});
        int path = 1;
        grid[0][0] = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c= curr[1];
                if(r==n-1 && c==n-1) return path;
                int[][] neighbours = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1}, 
                                        {r+1,c+1}, {r-1,c-1}, {r+1,c-1}, {r-1,c+1}};
                for(int neigh[] : neighbours){
                    int nr = neigh[0];
                    int nc = neigh[1];
                    if(nr<0 || nc<0 || nr>= n || nc >= m || grid[nr][nc] == 1) continue;
                    grid[nr][nc] = 1;
                    q.offer(new int[] {nr,nc});
                }                        
            }
            path++;
        }
        return -1;
    }
}