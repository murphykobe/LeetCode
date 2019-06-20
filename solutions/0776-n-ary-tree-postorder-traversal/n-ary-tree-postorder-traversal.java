// Given an n-ary tree, return the postorder traversal of its nodes' values.
//
// For example, given a 3-ary tree:
//
//  
//
//
//
//  
//
// Return its postorder traversal as: [5,6,3,2,4,1].
//  
//
// Note:
//
// Recursive solution is trivial, could you do it iteratively?
//


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> res=new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root==null){return res;}
        for(Node S: root.children){
              postorder(S);
        }
        res.add(root.val);
        return res;
    }
}
