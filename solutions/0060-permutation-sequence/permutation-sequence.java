class Solution {
    public String getPermutation(int n, int k) {
        char[] result=new char[n];
        ArrayList<Integer> nums=new ArrayList();
        int[] fac=new int[n];
        fac[0]=1;
        for(int i=1;i<n;i++){
            fac[i]=fac[i-1]*i;
            nums.add(i);
        }
        nums.add(n);
        k--;
        for(int i=0;i<n;i++){
            result[i]=Character.forDigit(nums.remove(k/fac[n-i-1]),10);
            k=k%fac[n-i-1];
        }
        
        return new String(result);
    }
}






