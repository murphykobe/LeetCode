// Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
//
// Note: The solution set must not contain duplicate subsets.
//
// Example:
//
//
// Input: [1,2,2]
// Output:
// [
//   [2],
//   [1],
//   [1,2,2],
//   [2,2],
//   [1,2],
//   []
// ]
//
//


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,nums,new ArrayList<Integer>(),0);
        return res;
    }
    
    public void dfs(List<List<Integer>> res,int[] nums,List<Integer> temp,int idx){
        res.add(new ArrayList<Integer>(temp));
        for(int i=idx;i<nums.length;i++){
            if(i > idx && nums[i] == nums[i-1]) continue;
            temp.add(nums[i]);
            dfs(res,nums,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

