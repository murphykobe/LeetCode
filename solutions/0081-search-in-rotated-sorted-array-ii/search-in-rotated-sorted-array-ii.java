class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length==0 || nums==null) return false;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target) return true;
            if(nums[mid]>nums[start]){
                if(target>=nums[start] && target<nums[mid])end=mid;
                else start=mid+1;
            }else if(nums[mid]<nums[start]){
                if(target<nums[start] && target>nums[mid]) start=mid+1;
                else end=mid;
            }else{
                start++;
            }
        }
        return false;
    }


}