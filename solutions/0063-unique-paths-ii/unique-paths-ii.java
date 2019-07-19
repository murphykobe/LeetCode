class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        if(m==0 || n==0) return 0;

        int[][] dp=new int[m+1][n+1];
        dp[1][1]= obstacleGrid[0][0]!=1 ? 1:0;

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(obstacleGrid[i-1][j-1]!=1){
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        
        return dp[m][n];
    }
}
    
