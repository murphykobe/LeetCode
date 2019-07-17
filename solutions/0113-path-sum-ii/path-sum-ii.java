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
    private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result=new ArrayList();
        if(root==null) return result;
        helper(new ArrayList(),root,sum);
        return result;
    }
    
    public void helper(List<Integer> temp, TreeNode root,int sum){
        if(root==null){
            return;
        }
        temp.add(root.val);
        if(root.val==sum && root.left==null && root.right==null){
            result.add(new ArrayList(temp));
            temp.remove(temp.size()-1);
            return;
        }else{
            helper(temp,root.left,sum-root.val);
            helper(temp,root.right,sum-root.val);
        }
        temp.remove(temp.size()-1);
    }
}

