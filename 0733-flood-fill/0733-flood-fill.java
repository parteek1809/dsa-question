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

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor=image[sr][sc];
        if(originalColor==color){
            return image;
        }
        dfs(image,sr,sc,originalColor,color);
        return image;  
    }
    public void dfs(int[][] image,int row,int col,int originalColor,int newColor){
        if(row<0 || col<0 ||row>=image.length ||col>=image[0].length){
            return;
        }
        if(image[row][col]!=originalColor){
            return;
        }
        image[row][col]=newColor;
        dfs(image,row-1,col,originalColor,newColor);
        dfs(image,row+1,col,originalColor,newColor);
        dfs(image,row,col-1,originalColor,newColor);
        dfs(image,row,col+1,originalColor,newColor);
    }
}
