// Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
//
// Example 1:
//
//
// Input: S = "loveleetcode", C = 'e'
// Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
//
//
//  
//
// Note:
//
//
// 	S string length is in [1, 10000].
// 	C is a single character, and guaranteed to be in string S.
// 	All letters in S and C are lowercase.
//
//


class Solution {
    public int[] shortestToChar(String S, char C) {
        List<Integer> index=new ArrayList<Integer>();
        int[] ans=new int[S.length()];
        int idx=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)==C){
                index.add(i);
            }
        }
        for(int i=0;i<ans.length;i++){
            int min=10000;
            for(int j=0; j< index.size(); j++){
                min=Math.min(min,Math.abs(index.get(j)-i));
                ans[i]=min;
            }
        }
        return ans;
    }
}
