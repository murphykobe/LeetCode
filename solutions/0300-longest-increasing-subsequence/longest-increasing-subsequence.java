// Given an unsorted array of integers, find the length of longest increasing subsequence.
//
// Example:
//
//
// Input: [10,9,2,5,3,7,101,18]
// Output: 4 
// Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
//
// Note: 
//
//
// 	There may be more than one LIS combination, it is only necessary for you to return the length.
// 	Your algorithm should run in O(n2) complexity.
//
//
// Follow up: Could you improve it to O(n log n) time complexity?
//


class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        int dp[] = new int[nums.length];
        dp[0]=1;
        int max=1;
        for(int i=0;i<nums.length;i++){
            int maxval=0;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    maxval=Math.max(maxval,dp[j]);
                }
            }
            dp[i]=maxval+1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
