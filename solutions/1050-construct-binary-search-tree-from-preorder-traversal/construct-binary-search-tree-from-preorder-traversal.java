// Return the root node of a binary search tree that matches the given preorder traversal.
//
// (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that a preorder traversal displays the value of the node first, then traverses node.left, then traverses node.right.)
//
//  
//
// Example 1:
//
//
// Input: [8,5,1,7,10,12]
// Output: [8,5,10,1,7,null,12]
//
//
//
//  
//
// Note: 
//
//
// 	1 <= preorder.length <= 100
// 	The values of preorder are distinct.
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
    public int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        
        return bsthelper(preorder,Integer.MAX_VALUE,Integer.MIN_VALUE);
         

    }
    public TreeNode bsthelper(int[] preorder,int max,int min){
        if(idx>=preorder.length || preorder[idx]<min || preorder[idx]>max){
            return null;
        }
        TreeNode root=new TreeNode(preorder[idx]);
        int val=root.val;
        idx++;
        
        root.left=bsthelper(preorder,val,min);
        root.right=bsthelper(preorder,max,val);
        
        return root;
    }
}
