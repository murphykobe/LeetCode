// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//
// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
//
// Example:
//
//
// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6
//


class Solution {
    public int trap(int[] height) {
        int l=0,r=height.length-1;
        int leftMax=0,rightMax=0;
        int res=0;
        while(l<r){
            if(height[l]<height[r]){
                leftMax=Math.max(leftMax,height[l]);
                res+=leftMax-height[l];
                l++;
            }else{
                rightMax=Math.max(rightMax,height[r]);
                res+=rightMax-height[r];
                r--;
                
                }
            
            }
        return res;
    }
}
