// Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
// Example:
//
//
// Input:  [1,2,3,4]
// Output: [24,12,8,6]
//
//
// Note: Please solve it without division and in O(n).
//
// Follow up:
// Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
//


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        int res[]=new int[len];
        
        int left=1;
        for(int i=0;i<len;i++){
            if(i>0){
                left=left*nums[i-1];
            }
            res[i]=left;
        }
        
        int right=1;
        for(int i=len-1;i>=0;i--){
            if(i<len-1){
                right=right*nums[i+1];
            }
            res[i]*=right;
        }
        return res;
        
    }
}


