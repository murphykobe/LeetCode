// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
//
//
// Note that it is the kth smallest element in the sorted order, not the kth distinct element.
//
//
// Example:
//
// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,
//
// return 13.
//
//
//
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ n2.


class Solution {
     public int kthSmallest(int[][] matrix, int k) {
          int row = matrix.length, col = matrix[0].length;
          int left = matrix[0][0], right = matrix[row - 1][col - 1];
          while (left < right) {
            int mid = left + (right - left) / 2;
            if (count(matrix, mid) <= k - 1) {
              left = mid + 1;
            } else {
              right = mid;
            }
          }
          return left;
        }
    public int count(int[][] matrix, int val) {
          int row = matrix.length, col = matrix[0].length;
          int cnt = 0;
          for (int i = 0, j = col - 1; i < row && j >= 0;) {
            if (matrix[i][j] > val) j--;
            else {
              cnt += j + 1;
              i++;
            }
          }
          return cnt;
    }
}
