// Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
//
// You have the following 3 operations permitted on a word:
//
//
// 	Insert a character
// 	Delete a character
// 	Replace a character
//
//
// Example 1:
//
//
// Input: word1 = "horse", word2 = "ros"
// Output: 3
// Explanation: 
// horse -> rorse (replace 'h' with 'r')
// rorse -> rose (remove 'r')
// rose -> ros (remove 'e')
//
//
// Example 2:
//
//
// Input: word1 = "intention", word2 = "execution"
// Output: 5
// Explanation: 
// intention -> inention (remove 't')
// inention -> enention (replace 'i' with 'e')
// enention -> exention (replace 'n' with 'x')
// exention -> exection (replace 'n' with 'c')
// exection -> execution (insert 'u')
//
//


class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        
        int[][] res=new int[m+1][n+1];
        
        for(int i = 0; i <= m; i++)
            res[i][0] = i;
        for(int i = 1; i <= n; i++)
            res[0][i] = i;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    res[i+1][j+1]=res[i][j];
                }else{
                    res[i+1][j+1]=Math.min(Math.min(1+res[i][j],1+res[i][j+1]),1+res[i+1][j]);
                }
                
            }
        }
        return res[m][n];
        
    }
}


