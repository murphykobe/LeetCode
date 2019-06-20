// Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
// Example:
//
//
// Input: [1,1,2]
// Output:
// [
//   [1,1,2],
//   [1,2,1],
//   [2,1,1]
// ]
//
//


class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        Arrays.sort(nums);
        dfs(res,nums,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }
    public void dfs(List<List<Integer>> res,int[] nums,List<Integer> temp, boolean[] used){
        if(temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i] || i>0 && nums[i]==nums[i-1] && !used[i-1])continue;
                used[i]=true;
                temp.add(nums[i]);
                dfs(res,nums,temp,used);
                used[i]=false;
                temp.remove(temp.size()-1);
            }
        }
    }
}


