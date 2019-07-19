class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList();
        dfs(result,new ArrayList(),n,k,1);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> temp,int n,int k,int s){
        if(k==0){
            result.add(new ArrayList(temp));
        }
        
        for(int i=s;i<=n;i++){
            temp.add(i);
            dfs(result,temp,n,k-1,i+1);
            temp.remove(temp.size()-1);
        }
        
    }
}
