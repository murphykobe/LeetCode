// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example:
//
//
// Input:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.
//
//


class Solution {
    public int minPathSum(int[][] grid) {
        int x=grid.length;
        int y=grid[0].length;
        for(int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if(i==0 && j!=0){
                    grid[i][j]=grid[i][j]+grid[i][j-1];
                }else if(i!=0 && j==0){
                    grid[i][j]=grid[i][j]+grid[i-1][j];
                }else if(i==0 && j==0){
                    grid[i][j]=grid[i][j];
                }else{
                    grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[x-1][y-1];
    }
}




