class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        int original = image[sr][sc];
        if(original == color) return image;
        q.add(new int[] {sr,sc});
        while(!q.isEmpty()){

            int curr[] = q.remove();
            int r = curr[0];
            int c = curr[1];
            image[r][c] = color;
            int neighbour[][] = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1} };
            for(int neigh[] : neighbour){
                int nr = neigh[0];
                int nc = neigh[1];
                if(nr<0 || nc<0 || nr>=m || nc>=n || image[nr][nc] != original) continue;
                image[nr][nc] = color;
                q.add(new int[] {nr,nc});
            }
        }
        return image;
    }
}