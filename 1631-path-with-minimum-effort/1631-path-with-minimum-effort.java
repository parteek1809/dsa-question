class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for(int rows[] : dist ){
            Arrays.fill(rows, Integer.MAX_VALUE);
        }
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,1,-1};
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>(){
        //     public int compare(int first[], int[] second){
        //         return first[0]-second[0];
        //     }
        // });
        dist[0][0] = 0;
        q.add(new int[] {0,0,0});
        while(!q.isEmpty()){
            int curr[] = q.poll();
            int effort = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(r == n-1 && c == m-1) return effort;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (effort > dist[r][c]) continue;  // reduce unnecessary steps
                if(nr<0 || nc<0 || nr>=n || nc>= m ) continue;
                int edgeDistance = Math.abs(heights[r][c] - heights[nr][nc]);
                int newEffort = Math.max(edgeDistance, effort);
                if(newEffort < dist[nr][nc]){
                    dist[nr][nc] = newEffort;
                    q.add(new int[] {newEffort, nr,nc});
                }
            }
        }
        return -1;
    }
}