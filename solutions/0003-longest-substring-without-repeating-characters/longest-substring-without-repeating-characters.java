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
        int[] map=new int[128];
        int start=0,end=0,counter=0,maxLen=0;
        
        while(end<s.length()){
            final char c1=s.charAt(end);
            if(map[c1]>0) counter++;
            map[c1]++;
            end++;
            while(counter>0){
                final char c2=s.charAt(start);
                if(map[c2]>1) counter--;
                map[c2]--;
                start++;
            }
            maxLen=Math.max(maxLen,end-start);
        }
        return maxLen;
    }
}