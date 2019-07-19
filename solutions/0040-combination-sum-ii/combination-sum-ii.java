class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList();
        if(candidates.length==0) return result;
        Arrays.sort(candidates);
        dfs(result,new ArrayList(),candidates,target,0);
        return result;
        
    }
    public void dfs(List<List<Integer>> result,List<Integer> temp,int[] can,int target,int cur){
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList(temp));
            return;
        }

        for(int i=cur;i<can.length;i++){
            if(i>cur && can[i]==can[i-1]) continue;
            temp.add(can[i]);
            dfs(result,temp,can,target-can[i],i+1);
            temp.remove(temp.size()-1);
        }
        
        
        
    }
}