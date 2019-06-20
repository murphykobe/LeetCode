// Given a binary tree, return the inorder traversal of its nodes' values.
//
// Example:
//
//
// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3
//
// Output: [1,3,2]
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        traverse(root,res);
        return res;
    }
    
    public void traverse(TreeNode root,List<Integer> res){
        if(root==null) return;
        

        TreeNode cur=root;
        if(cur.left!=null){
            traverse(root.left,res);
        }
        res.add(cur.val);
        if(cur.right!=null){
            traverse(root.right,res);
        }
        
        
        
        
    }
}
