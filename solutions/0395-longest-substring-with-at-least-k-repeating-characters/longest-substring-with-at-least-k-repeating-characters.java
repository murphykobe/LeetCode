class Solution {
    public int longestSubstring(String s, int k) {
        int len=0;
        for(int i=1;i<=26;i++){
            len=Math.max(len,helper(s,k,i));
        }
        
        return len;
    }
        
        
    public int helper(String s,int k,int target){
        int[] map =new int[128];
        int start=0,end=0,unique=0,lessk=0,d=0;
        
        while(end<s.length()){
            final char c1=s.charAt(end);
            if(map[c1]==0) unique++;
            map[c1]++;
            if(map[c1]==k) lessk++;
            end++;
            while(unique>target){
                final char c2=s.charAt(start);
                if(map[c2]==k) lessk--;
                map[c2]--;
                if(map[c2]==0) unique--;
                start++;   
            }
            if(unique==target && unique==lessk){
                d=Math.max(d,end-start);
            }
        }
        return d;
    }
}