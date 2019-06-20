// Given an n-ary tree, return the preorder traversal of its nodes' values.
//
// For example, given a 3-ary tree:
//
//  
//
//
//
//  
//
// Return its preorder traversal as: [1,3,5,6,2,4].
//
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
    public List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null){return res;}
        res.add(root.val);
        for(Node S: root.children){
            preorder(S);
        }
       return res;
    }
}
