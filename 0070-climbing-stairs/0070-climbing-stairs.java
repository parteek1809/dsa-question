class Solution {
    public int climbStairs(int n){
        int dp[] = new int[n+1];
        int ans = stair(n, dp);
        return ans;
    }
    public int stair(int n, int dp[]){
        if(n==1 || n==2) return n;
        if(dp[n] != 0) return dp[n];
        dp[n] = stair(n-1, dp) + stair(n-2, dp);
        return dp[n];
    }
}





// class Solution {
//     public int climbStairs(int n) {
//         if(n==1 || n==2) return n;
//         return climbStairs(n-1) + climbStairs(n-2);
//     }
// }