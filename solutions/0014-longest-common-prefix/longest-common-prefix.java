// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res=new StringBuilder();
        if(strs.length==0 || strs==null) return "";
        Arrays.sort(strs);
        char[] c1=strs[0].toCharArray();
        char[] c2=strs[strs.length-1].toCharArray();
        for(int i=0;i<c1.length;i++){
            if(i<c2.length && c1[i]==c2[i]){
                res.append(c1[i]);
            }else{
                break;
            }
        }
        return res.toString();
    }
}