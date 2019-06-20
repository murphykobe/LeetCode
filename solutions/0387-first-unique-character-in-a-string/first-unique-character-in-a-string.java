//
// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
// Examples:
//
// s = "leetcode"
// return 0.
//
// s = "loveleetcode",
// return 2.
//
//
//
//
// Note: You may assume the string contain only lowercase letters.
//


class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int l=s.length();
        int result=0;
        if(l==0){return -1;}
        for(int i=0;i<l;i++){
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i=0;i<l;i++){
            if(count.get(s.charAt(i))==1) {
                result=i;
                break;
            }
            else{
                result=-1;
            }
        }
        return result;
            
        }
    }

