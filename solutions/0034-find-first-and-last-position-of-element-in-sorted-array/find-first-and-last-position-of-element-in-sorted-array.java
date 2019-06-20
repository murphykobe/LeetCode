// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
// Your algorithm's runtime complexity must be in the order of O(log n).
//
// If the target is not found in the array, return [-1, -1].
//
// Example 1:
//
//
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
//
// Example 2:
//
//
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
//


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        int[] res=new int[]{-1,-1};
        int lo=0;
        int hi=nums.length-1;
        while (lo<hi){
            int mid=lo+(hi-lo)/2;
            if(target>nums[mid]){
                lo=mid+1;
            }else{
                hi=mid;
            }
        }
        if(nums[lo]==target){
            res[0]=lo;
        }else{
            res[0]=-1;
        }
        
        hi=nums.length-1;
        while(lo<hi){
            int mid=lo+(hi-lo)/2+1;
            if(target<nums[mid]){
                hi=mid-1;
            }else{
                lo=mid;
            }
        }
        if(nums[hi]==target){
            res[1]=hi;
        }else{
            res[1]=-1;
        }
        return res;
    }
}
