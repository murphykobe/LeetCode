class Solution {
    public int[][] generateMatrix(int n) {
        int top=0,left=0;
        int right=n-1;
        int bottom=n-1;
        int[][] result=new int[n][n];
        int a=1;
        while(left<=right){
            for(int i=left;i<=right;i++){
                result[top][i]=a++;
            }
            top++;
            for(int i=top;i<=bottom;i++){
                result[i][right]=a++;
            }
            right--;
            for(int i=right;i>=left;i--){
                result[bottom][i]=a++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                result[i][left]=a++;
            }
            left++;
        }
        return result;
    }
}
