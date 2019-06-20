// Given an array of strings, group anagrams together.
//
// Example:
//
//
// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
//
// Note:
//
//
// 	All inputs will be in lowercase.
// 	The order of your output does not matter.
//
//


class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String,List> res=new HashMap<String,List>();
        
        for(String str:strs){
            char[] temp=str.toCharArray();
            Arrays.sort(temp);
            String key=String.valueOf(temp);
            if(!res.containsKey(key)) res.put(key, new ArrayList());
            res.get(key).add(str);
            
        }
        return new ArrayList(res.values());
        
    }
}
