// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// Example 1:
//
//
// Input: "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()"
//
//
// Example 2:
//
//
// Input: ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()"
//
//


class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack=new Stack<Integer>();
        int res=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')' && stack.size()>1 && s.charAt(stack.peek())=='('){
                stack.pop();
                res=Math.max((i-stack.peek()),res);
            }else{
                stack.push(i);
            }
        }
        return res;
            
        
    }
}
