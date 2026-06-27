class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // boolean vis[][] = new boolean[m][n];
        for(int i=0; i<n; i++){  //top
            if(board[0][i] == 'O'){
                dfs(board, 0, i);
            }
        } 
        for(int i=0; i<n; i++){  //bottom
            if(board[m-1][i] == 'O'){
                dfs(board, m-1, i);
            }
        } 
        for(int i=1; i<m-1; i++){   // left
            if(board[i][0] == 'O'){
                dfs(board, i, 0);
            }
        } 
        for(int i=1; i<m-1; i++){
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1);
            }
        }
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        } 
    }
    public void dfs(char[][] board, int r, int c ){
        // vis[r][c] = true;
        int m = board.length;
        int n = board[0].length;
        if(r<0 || c<0 || r>=m || c>=n || board[r][c] != 'O' ) return;
        board[r][c] = '#';
        // vis[r][c] = true;
        int[][] neighbour = { {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1}};
        for(int neigh[] : neighbour){ 
            int nr = neigh[0];
            int nc = neigh[1];
            dfs(board, nr, nc);
        }
    }
}