class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        int a=Math.abs(dividend);
        int b=Math.abs(divisor);
        int res=0;
        int x;
        while(a-b>=0){
            for (x = 0; a - (b << x << 1) >= 0; x++);
            res += 1 << x;
            a -= b << x;
        }
        return (dividend>0)==(divisor>0)? res: -res;
    }
}