// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
//
// Example 1:
//
// Input:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
//
//
//
// Note:
//
// The range of node's value is in the range of 32-bit signed integer.
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res=new LinkedList<Double>();
        if(root==null) return res;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode cur;
            double sum=0;
            int n=queue.size();
            for(int i=0;i<n;i++){
                cur=queue.poll();
                if(cur.left!=null) queue.add(cur.left);
                if(cur.right!=null) queue.add(cur.right);
                sum+=cur.val;
            }
            res.add((double)sum/n);
        }
        return res;
        
    }
}
