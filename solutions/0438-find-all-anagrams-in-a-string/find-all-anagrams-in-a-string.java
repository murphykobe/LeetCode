// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
//
// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
//
// The order of output does not matter.
//
// Example 1:
//
// Input:
// s: "cbaebabacd" p: "abc"
//
// Output:
// [0, 6]
//
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
//
//
//
// Example 2:
//
// Input:
// s: "abab" p: "ab"
//
// Output:
// [0, 1, 2]
//
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result=new LinkedList<>();
        if(p.length()>s.length()) return result;
        Map<Character,Integer> map=new HashMap();
        for(char c:p.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int counter=map.size();
        int start=0,end=0;
        int len=Integer.MAX_VALUE;
        
        while(end<s.length()){
            char c=s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) counter--;
            }
            end++;
            while(counter==0){
                char d=s.charAt(start);
                if(map.containsKey(d)){
                    map.put(d,map.get(d)+1);
                    if(map.get(d)>0) counter++;
                }
                if(end-start==p.length()){
                    result.add(start);
                }
                start++;
            }
        }
        
        return result;
        
        
    }
}
