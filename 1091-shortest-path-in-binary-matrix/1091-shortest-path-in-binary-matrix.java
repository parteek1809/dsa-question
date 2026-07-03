// class Solution {
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1; // edge case
//         Queue<int[]> q = new LinkedList<>();
//         q.offer(new int[] {0,0});
//         int path = 1;
//         grid[0][0] = 1;
//         while(!q.isEmpty()){
//             int size = q.size();
//             for(int i=0; i<size; i++){
//                 int[] curr = q.poll();
//                 int r = curr[0];
//                 int c= curr[1];
//                 if(r==n-1 && c==n-1) return path;
//                 int[][] neighbours = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1}, 
//                                         {r+1,c+1}, {r-1,c-1}, {r+1,c-1}, {r-1,c+1}};
//                 for(int neigh[] : neighbours){
//                     int nr = neigh[0];
//                     int nc = neigh[1];
//                     if(nr<0 || nc<0 || nr>= n || nc >= m || grid[nr][nc] == 1) continue;
//                     grid[nr][nc] = 1;
//                     q.offer(new int[] {nr,nc});
//                 }                        
//             }
//             path++;
//         }
//         return -1;
//     }
// }

import java.util.*;

class Solution {

    class Node {
        int dist;
        int row;
        int col;

        Node(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dir = {
            {-1,-1},{-1,0},{-1,1},
            {0,-1},        {0,1},
            {1,-1},{1,0},{1,1}
        };

        int[][] distance = new int[n][n];

        for (int[] row : distance)
            Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq =
                new PriorityQueue<>((a, b) -> a.dist - b.dist);

        distance[0][0] = 1;

        pq.offer(new Node(1, 0, 0));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            int dist = curr.dist;
            int r = curr.row;
            int c = curr.col;

            // Skip outdated entries
            if (dist > distance[r][c])
                continue;

            if (r == n - 1 && c == n - 1)
                return dist;

            for (int[] d : dir) {

                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0) {

                    if (dist + 1 < distance[nr][nc]) {

                        distance[nr][nc] = dist + 1;

                        pq.offer(new Node(dist + 1, nr, nc));
                    }
                }
            }
        }

        return -1;
    }
}