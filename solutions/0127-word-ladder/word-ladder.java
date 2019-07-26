class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        	if (!wordList.contains(endWord)) return 0;
			
            Set<String> visited=new HashSet();
            Set<String> dict=new HashSet(wordList);
        
            Queue<String> q=new LinkedList();
        
            int level=1;
        
            q.add(beginWord);
        
            while(!q.isEmpty()){
                int size=q.size();
                for(int i=0;i<size;i++){
                    String s=q.poll();
                    for(int j=0;j<s.length();j++){
                        char[] ch=s.toCharArray();
                        for(char c='a';c<='z';c++){
                            ch[j]=c;
                            String word=new String(ch);
                            if(word.equals(endWord)) return level+1;
                            if(dict.contains(word) && !visited.contains(word)){
                                q.add(word);
                                visited.add(word);
                            }
                        }
                    }
                }
                
                level++;
            }
            return 0;
       }
}