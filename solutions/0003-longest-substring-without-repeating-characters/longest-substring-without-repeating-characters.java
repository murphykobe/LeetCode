// Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
//
//
//
// Example 2:
//
//
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//
//


class Solution {
    public int lengthOfLongestSubstring(String s) {
        int g=0;
        int f=0;
        int max=0; 
        Set<Character> set = new HashSet<>();
        while(g<s.length() && f<s.length()){
            if(!set.contains(s.charAt(f))){
                set.add(s.charAt(f++));
                max=Math.max(max,f-g);
            }else{
                set.remove(s.charAt(g++));
            }
        }
        return max;
    }
}
