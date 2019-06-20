//
// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
//
//
//
// For example, given n = 3, a solution set is:
//
//
// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]
//


class Solution {
    public List<String> generateParenthesis(int n) {
        int l=0;
        int r=0;
        List<String> res=new ArrayList<>();
        dfs("",res,n,0,0);
        return res;
    }
    
    public void dfs(String s,List<String> res,int n,int l,int r){
        if(s.length()==2*n){
            res.add(s);
        }else{
            if(l<n){
                dfs(s+'(',res,n,l+1,r);
            }
            if(r<l){
                dfs(s+')',res,n,l,r+1);
            }
        }
    }
}
