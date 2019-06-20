// Given a string s, partition s such that every substring of the partition is a palindrome.
//
// Return all possible palindrome partitioning of s.
//
// Example:
//
//
// Input: "aab"
// Output:
// [
//   ["aa","b"],
//   ["a","a","b"]
// ]
//
//


class Solution {
    public List<List<String>> res=new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0)
            return res;
        dfs(new ArrayList<String>(),s,0);
        return res;
    }
    
    public void dfs(List<String> remain, String s, int left){
        if(left==s.length()){
            res.add(new ArrayList<String>(remain));
            return;
        }
        for(int right=left;right<s.length();right++){
            if(isPalindrome(s,left,right)){
                remain.add(s.substring(left,right+1));
                dfs(remain,s,right+1);
                remain.remove(remain.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s,int i,int j){
        while(i<j && s.charAt(i)==s.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }
}
