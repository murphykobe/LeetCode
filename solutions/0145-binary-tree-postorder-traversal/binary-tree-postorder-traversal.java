// Given a binary tree, return the postorder traversal of its nodes' values.
//
// Example:
//
//
// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// Output: [3,2,1]
//
//
// Follow up: Recursive solution is trivial, could you do it iteratively?
//


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(TreeNode root,List<Integer> res){
        if(root !=null){
            
            if(root.left!=null){
                helper(root.left,res);
            }
            if(root.right!=null){
                helper(root.right,res);
            }
            res.add(root.val);
        }
    }
}
