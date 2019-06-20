// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its zigzag level order traversal as:
//
// [
//   [3],
//   [20,9],
//   [15,7]
// ]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        TreeNode c;
        s1.push(root);
        while(!s1.isEmpty()||!s2.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            while(!s1.isEmpty()){
                c = s1.pop();
                temp.add(c.val);
                if(c.left!=null) s2.push(c.left);
                if(c.right!=null) s2.push(c.right);
            }
            ans.add(temp);
            temp= new ArrayList<>();
            while(!s2.isEmpty()){
                c = s2.pop();
                temp.add(c.val);
                if(c.right!=null) s1.push(c.right);
                if(c.left!=null) s1.push(c.left);
            }
            if(!temp.isEmpty()) ans.add(temp);
        }
        return ans;
    }
}
