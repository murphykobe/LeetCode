// Given a set of distinct integers, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]
//


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        dfs(res,nums,new ArrayList<Integer>(),0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res,int[] nums,List<Integer> temp,int idx){
        res.add(new ArrayList<Integer>(temp));
        for(int i=idx;i<nums.length;i++){
            temp.add(nums[i]);
            dfs(res,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }

    }
}
