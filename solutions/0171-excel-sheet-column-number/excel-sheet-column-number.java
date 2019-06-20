// Given a column title as appear in an Excel sheet, return its corresponding column number.
//
// For example:
//
//
//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...
//
//
// Example 1:
//
//
// Input: "A"
// Output: 1
//
//
// Example 2:
//
//
// Input: "AB"
// Output: 28
//
//
// Example 3:
//
//
// Input: "ZY"
// Output: 701
//


class Solution {
    public int titleToNumber(String s) {
        int result=0;
    for(int i=s.length()-1;i>=0;i--){
         char ch = s.charAt(i);
         result=result+((int)ch-64)*((int)Math.pow(26, (s.length()-1-i)));
    }
    return result;
    }
}
