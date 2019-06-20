// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
// Example:
//
//
// Input: 
//
// 1 0 1 0 0
// 1 0 1 1 1
// 1 1 1 1 1
// 1 0 0 1 0
//
// Output: 4
//


class Solution {
    public int maximalSquare(char[][] matrix) {
        
        if(matrix.length==0) return 0;
        int m=matrix.length;
        int n=matrix[0].length;
        
        int[][] res=new int[m+1][n+1];
        
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]=='0'){
                    res[i+1][j+1]=0;
                }else{
                    res[i+1][j+1]=1+Math.min(res[i][j],Math.min(res[i+1][j],res[i][j+1]));
                    max=Math.max(res[i+1][j+1],max);
                }
            }
        }
        
        return max*max;
    }
}
