// Given a non-empty array of integers, return the k most frequent elements.
//
// Example 1:
//
//
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
//
//
//
// Example 2:
//
//
// Input: nums = [1], k = 1
// Output: [1]
//
//
// Note: 
//
//
// 	You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// 	Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
//
//


class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        
        List<Integer>[] bucket=new List[nums.length+1];
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        
        List<Integer> res=new ArrayList<>();
        
        for (int n:map.keySet()){
            int freq=map.get(n);
            if(bucket[freq]==null){
                bucket[freq]=new ArrayList<>();
            }
            bucket[freq].add(n);
        }
        
        for(int i=bucket.length-1; i>=0 && res.size()<k;i--){
            if(bucket[i]!=null){
                res.addAll(bucket[i]);
            }
        }
        
        return res;

    }
}
