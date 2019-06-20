// Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
//
//
// Example 1:
//
//
// Input: a = 1, b = 2
// Output: 3
//
//
//
// Example 2:
//
//
// Input: a = -2, b = 3
// Output: 1
//
//
//
//


class Solution {
    public int getSum(int a, int b) {
    int result = a ^ b; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
    int carry = (a & b) << 1; // 1+1=2
    if (carry != 0) {
        return getSum(result, carry);
    }
    return result;
    }
}
