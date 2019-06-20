// Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
// Your algorithm should run in O(n) complexity.
//
// Example:
//
//
// Input: [100, 4, 200, 1, 3, 2]
// Output: 4
// Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
//
//


class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        
        Arrays.sort(nums);
        
        int cur=1;
        int max=1;
        
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                if(nums[i]-nums[i-1]==1){
                    cur++;
                }else{
                    max=Math.max(cur,max);
                    cur=1;
                }
            }
        }
        return Math.max(cur,max);
    }
}




