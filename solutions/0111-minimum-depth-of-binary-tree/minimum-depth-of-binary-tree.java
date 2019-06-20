// Given a binary tree, find its minimum depth.
//
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
//
// Note: A leaf is a node with no children.
//
// Example:
//
// Given binary tree [3,9,20,null,null,15,7],
//
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
// return its minimum depth = 2.
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
    public int minDepth(TreeNode root) {
        return depth(root,0);
    }
    
    public int depth(TreeNode root,int d){
        if(root==null) return d;

        int l=depth(root.left,d+1);
        int r=depth(root.right,d+1);
    
        if(root.left==null) return r;
        if(root.right==null) return l;
        return Math.min(l,r);
    }
}
