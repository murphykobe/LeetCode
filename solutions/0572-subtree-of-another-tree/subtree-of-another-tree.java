/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        helper(s,s1.append(","));
        helper(t,s2.append(","));
        return s1.toString().contains(s2.toString());
    }
    
    public void helper(TreeNode t, StringBuilder s){
        if(t==null){
            s.append("#,");
            return;
        }
        s.append(Integer.toString(t.val)).append(",");
        helper(t.left,s);
        helper(t.right,s);
    }
}
