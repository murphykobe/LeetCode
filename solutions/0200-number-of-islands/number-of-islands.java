// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
// Input:
// 11110
// 11010
// 11000
// 00000
//
// Output: 1
//
//
// Example 2:
//
//
// Input:
// 11000
// 11000
// 00100
// 00011
//
// Output: 3
//


class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        if(m==0){return 0;}
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    DFSMarking(grid,i,j,m,n);
                }
            }
        }
        return count;
    }
    
    public void DFSMarking(char[][] grid, int i,int j,int m,int n){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]=='0'){return;}
        grid[i][j]='0';
        DFSMarking(grid,i+1,j,m,n);
        DFSMarking(grid,i-1,j,m,n);
        DFSMarking(grid,i,j+1,m,n);
        DFSMarking(grid,i,j-1,m,n);
    }
}
