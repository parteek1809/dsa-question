class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        int targetSum = sum / 2;
        boolean ans = subsetSum(nums, targetSum);
        return ans;
    }
    public boolean subsetSum(int nums[], int targetSum){
        boolean dp[][] = new boolean[nums.length+1][targetSum+1];
        for(int i=0; i<=nums.length; i++){
            dp[i][0] = true;
        }
        for(int i=1; i<=nums.length; i++){
            for(int j=1; j<=targetSum; j++){
                int v = nums[i-1];
                // if(v <= j && dp[i-1][j-v] == true){
                //     dp[i][j] = true;
                // }
                // else if(dp[i-1][j] == true){
                //     dp[i][j] = true;
                // }
                if(v<=j){
                    dp[i][j] = dp[i-1][j-v] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[nums.length][targetSum];
    }
}