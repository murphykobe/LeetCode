// Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
//
// You may return the answer in any order.
//
//  
//
//
// Example 1:
//
//
// Input: ["bella","label","roller"]
// Output: ["e","l","l"]
//
//
//
// Example 2:
//
//
// Input: ["cool","lock","cook"]
// Output: ["c","o"]
//
//
//  
//
// Note:
//
//
// 	1 <= A.length <= 100
// 	1 <= A[i].length <= 100
// 	A[i][j] is a lowercase letter
//
//
//


class Solution {
 public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        if (A == null || A.length == 0) return res;
        int[] c = new int[26];
        for (char a : A[0].toCharArray())
        {
            c[a - 'a']++;
        }
        for (int i = 1; i < A.length; i++)
        {
            int[] c1 = new int[26];
            for (char a : A[i].toCharArray())
            {
                if (c[a - 'a'] != 0)
                {
                    c1[a - 'a']++;
                }
            }
            for (int j = 0; j < 26; j++)
            {
                c[j] = Math.min(c[j], c1[j]);
            }
        }
        for (int i = 0; i < 26; i++)
        {
            if (c[i] != 0)
            {
                for (int j = 0; j < c[i]; j++)
                {
                    res.add(String.valueOf((char)('a' + i)));
                }
            }
        }
        return res;
    }
}
