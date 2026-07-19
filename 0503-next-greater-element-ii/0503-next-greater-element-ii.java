class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];
        Arrays.fill(ans,-1);
        Stack<Integer> s = new Stack<>();
        for(int i=2*n-1; i>=0; i--){
            int num = nums[i%n];  // edge case for 3 4 5 if nums.length is 3
            while(!s.isEmpty() && s.peek() <= num){
                s.pop();
            }
            if(i<n && !s.isEmpty()){
                ans[i] = s.peek();
            }
            s.push(num);
        }
        return ans;
    }
}