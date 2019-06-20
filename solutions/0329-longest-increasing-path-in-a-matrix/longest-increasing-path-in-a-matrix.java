// Given an integer matrix, find the length of the longest increasing path.
//
// From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
//
// Example 1:
//
//
// Input: nums = 
// [
//   [9,9,4],
//   [6,6,8],
//   [2,1,1]
// ] 
// Output: 4 
// Explanation: The longest increasing path is [1, 2, 6, 9].
//
//
// Example 2:
//
//
// Input: nums = 
// [
//   [3,4,5],
//   [3,2,6],
//   [2,2,1]
// ] 
// Output: 4 
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
//
//


class Solution {
    private int m;
    private int n;
    private int [][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0 || matrix==null) return 0;
        m=matrix.length;
        n=matrix[0].length;
        cache=new int[m][n];
        int max=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max=Math.max(max,findSmallAround(matrix,i,j,Integer.MIN_VALUE));
            }
        }
        return max;
    }
    private int findSmallAround( int[][] matrix,int i, int j,int pre) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= pre) {
            return 0;
        }
        if (cache[i][j] > 0) {
            return cache[i][j];
        } else {
            int cur = matrix[i][j];
            int tempMax = 0;
            tempMax = Math.max(findSmallAround( matrix, i - 1, j,cur), tempMax);
            tempMax = Math.max(findSmallAround( matrix, i + 1, j,cur), tempMax);
            tempMax = Math.max(findSmallAround( matrix, i, j - 1,cur), tempMax);
            tempMax = Math.max(findSmallAround( matrix, i, j + 1,cur), tempMax);
            cache[i][j] = ++tempMax;
            return tempMax;
        }
    }
}
