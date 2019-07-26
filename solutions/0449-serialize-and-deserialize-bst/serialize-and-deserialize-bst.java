/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        if(root==null) return "";
        serial(root, sb);
        return sb.toString();
    }
    
    public StringBuilder serial(TreeNode root,StringBuilder sb){
        if(root==null) return sb;
        sb.append(root.val).append(",");
        serial(root.left,sb);
        serial(root.right,sb);
        return sb;
    }
    
    public TreeNode deserial(Integer lower,Integer upper,Queue<String> q){
        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        q.poll();
        TreeNode root=new TreeNode(val);
        root.left=deserial(lower,val,q);
        root.right=deserial(val,upper,q);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserial(Integer.MIN_VALUE,Integer.MAX_VALUE,q);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));