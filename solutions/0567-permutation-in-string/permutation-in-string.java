class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] map=new int[128];
        for(int i=0;i<s1.length();i++){
            int idx=s1.charAt(i);
            map[idx]++;
        }
        for(int i=0;i<s2.length();i++){
            int idy=s2.charAt(i);
            map[idy]--;
            if(i>=s1.length()) map[s2.charAt(i-s1.length())]++;
            if (allZero(map)) return true;
        }
        return false;
    }
    
    public boolean allZero(int[] map){
        for(int n:map){
            if(n!=0){
                return false;
            }
        }
        return true;
    }
}

