// Given preorder and inorder traversal of a tree, construct the binary tree.
//
// Note:
// You may assume that duplicates do not exist in the tree.
//
// For example, given
//
//
// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
//
// Return the following binary tree:
//
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart>preorder.length-1 || inStart> inEnd) return null;
    
    int inIndex=0;
    
    TreeNode root=new TreeNode(preorder[preStart]);
    for(int i=inStart;i<=inEnd;i++){
        if(root.val==inorder[i]){
            inIndex=i;
        }
    }
    
    root.left=helper(preStart+1, inStart, inIndex-1, preorder, inorder);
    root.right=helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder,inorder);
    return root;
    }
    
}
