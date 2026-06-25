class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOrange = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new int[] {i,j});
                }
                else if (grid[i][j] == 1){
                    freshOrange++;
                }
            }
        }
        if(freshOrange == 0) return 0;

        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int rotten[] = q.remove();
                int r =rotten[0];
                int c = rotten[1];
                int neighbour[][] = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1} };
                for(int neigh[] : neighbour){
                    int nr = neigh[0];
                    int nc = neigh[1];
                    if(nr<0 || nc<0 || nr>=m || nc>= n || grid[nr][nc] == 2 || grid[nr][nc] == 0){
                        continue;
                    }
                    grid[nr][nc] = 2;
                    q.add(new int[] {nr,nc});
                    freshOrange--;
                    if(freshOrange == 0){
                        return time+1;
                    }
                }
            }
            time++;
        }
        return -1;
    }
}