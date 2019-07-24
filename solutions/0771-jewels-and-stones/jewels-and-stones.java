class Solution {
    public int numJewelsInStones(String J, String S) {
        if(J.length()==0 || S.length()==0) return 0;
        Set<Character> set=new HashSet();
        int count=0;
        for(char c:J.toCharArray()){
            set.add(c);
        }
        for(int i=0;i<S.length();i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
        
        return count;
    }
}