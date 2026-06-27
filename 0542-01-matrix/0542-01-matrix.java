// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int arr[][] = new int[m][n];
//         // int dis = 0;
//         Queue<int[]> q = new LinkedList<>();
//         boolean vis[][] = new boolean[m][n];
//         for(int i=0; i<m; i++){
//             for(int j=0; j<n; j++){
//                 if(mat[i][j] == 0){
//                     q.add(new int[] {i,j});
//                     vis[i][j] = true;
//                     arr[i][j] = 0;
//                 }                
//             }
//         }
//         while(!q.isEmpty()){
//             int curr[] = q.poll();
//             int r = curr[0];
//             int c = curr[1];
//             int neighbour[][] = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1} };
//             for(int neigh[] : neighbour){
//                 int nr = neigh[0];
//                 int nc = neigh[1];
//                 if(nr<0 || nc<0 || nr>=m || nc>=n || vis[nr][nc] == true) continue;
//                 vis[nr][nc] = true;
//                 arr[nr][nc] = arr[r][c] +1;
//                 q.add(new int[] {nr,nc});
//             }
//         }
//         return arr;
//     }
// }


// class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         Queue<int[]> q = new LinkedList<>();
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (mat[i][j] == 0) {
//                     q.offer(new int[]{i, j});
//                 } else {
//                     mat[i][j] = Integer.MAX_VALUE;
//                 }
//             }
//         }

//         int[] dr = {-1, 1, 0, 0};
//         int[] dc = {0, 0, -1, 1};
        
//         while (!q.isEmpty()) {
//             int[] curr = q.poll();
//             int r = curr[0];
//             int c = curr[1];
//             for (int k = 0; k < 4; k++) {
//                 int nr = r + dr[k];
//                 int nc = c + dc[k];
//                 if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] > mat[r][c] + 1) {
//                     mat[nr][nc] = mat[r][c] + 1;
//                     q.offer(new int[]{nr, nc});
//                 }
//             }
//         }

//         return mat;
//     }
// }
            
class Pair{
    int first;
    int second;
    int third;
    public Pair(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        
        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        
        int[] dRow = {-1, 0, +1, 0};
        int[] dCol = {0, +1, 0, -1};
        
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int distance = q.peek().third;
            dist[row][col] = distance;
            q.poll();
            
            for(int i=0; i<4; i++){
                int nrow = row + dRow[i];
                int ncol = col + dCol[i];
                
                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.offer(new Pair(nrow, ncol, distance+1));
                }
            }
        }
        return dist;
    }
}                
            