// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
//
// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
//
// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
//
// Return true if and only if the nodes corresponding to the values x and y are cousins.
//
//  
//
// Example 1:
//
//
//
// Input: root = [1,2,3,4], x = 4, y = 3
// Output: false
//
//
//
// Example 2:
//
//
//
// Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
// Output: true
//
//
//
// Example 3:
//
//
//
//
// Input: root = [1,2,3,null,4], x = 2, y = 3
// Output: false
//
//  
//
//
//
// Note:
//
//
// 	The number of nodes in the tree will be between 2 and 100.
// 	Each node has a unique integer value from 1 to 100.
//
//
//
//
//  
//
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
    int depx;
    int depy;
    TreeNode parx;
    TreeNode pary;
    public boolean traverse(TreeNode root,int x,int y,int depth){
        if(root==null){return false;}
        if(root.right!=null && root.right.val==x || root.left!=null && root.left.val==x){
            parx=root;
            depx=depth+1;
        }
        if(root.right!=null && root.right.val==y || root.left!=null && root.left.val==y){
            pary=root;
            depy=depth+1;
        }
        if(parx!=null && pary!=null && parx!=pary && depx==depy){
            return true;
        }
        
        return traverse(root.left,x,y,depth+1) || traverse(root.right,x,y,depth+1);
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        return traverse(root,x,y,0);
    }
}
