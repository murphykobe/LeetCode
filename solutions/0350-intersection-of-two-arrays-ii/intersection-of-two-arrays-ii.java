// Given two arrays, write a function to compute their intersection.
//
// Example 1:
//
//
// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
//
//
//
// Example 2:
//
//
// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [4,9]
//
//
// Note:
//
//
// 	Each element in the result should appear as many times as it shows in both arrays.
// 	The result can be in any order.
//
//
// Follow up:
//
//
// 	What if the given array is already sorted? How would you optimize your algorithm?
// 	What if nums1's size is small compared to nums2's size? Which algorithm is better?
// 	What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
//
//


class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int l1=nums1.length;
        int l2=nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new ArrayList<>();
        int counter=0;
        int i=0;
        int j=0;
        while(i<l1 && j<l2){
            if(nums1[i]==nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
                counter++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int[] ans=new int[counter];
        for(int k=0;k<res.size();k++){
            ans[k] = (Integer)res.get(k);
        }
        return ans;
        
    }
}
