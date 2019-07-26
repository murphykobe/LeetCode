class Solution {
    public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0){
            return null;
        }
        int[] map=new int[26];
        List<Integer> result=new ArrayList();
        
        for(int i=0;i<S.length();i++){
            map[S.charAt(i)-'a']=i;
        }
        int last=0;
        int start=0;
        for(int i=0;i<S.length();i++){
            last=Math.max(last,map[S.charAt(i)-'a']);
            if(last==i){
                result.add(last-start+1);
                start=i+1;
            }
        }
        return result;
    }
}