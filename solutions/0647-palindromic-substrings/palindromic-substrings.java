// Given a string, your task is to count how many palindromic substrings in this string.
//
// The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
//
// Example 1:
//
//
// Input: "abc"
// Output: 3
// Explanation: Three palindromic strings: "a", "b", "c".
//
//
//  
//
// Example 2:
//
//
// Input: "aaa"
// Output: 6
// Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
//
//
//  
//
// Note:
//
//
// 	The input string length won't exceed 1000.
//
//
//  
//


class Solution {
    public int cnt=0;
    public int countSubstrings(String s) {
        if(s.length()==0 || s==null) return 0;
        
        for(int i=0;i<s.length();i++){
            extandP(s,i,i);
            extandP(s,i,i+1);
        }
        
        return cnt;
    }
    
    public void extandP(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            cnt++; l--; r++;
        }
    }
}
