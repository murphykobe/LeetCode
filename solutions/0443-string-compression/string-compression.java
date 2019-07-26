class Solution {
    public int compress(char[] chars) {
        int i=0;
        int j=0;
        while(i<chars.length){
            char curChar=chars[i];
            int count=0;
            while(i<chars.length && chars[i]==curChar){
                i++;
                count++;
            }
            chars[j++]=curChar;
            if(count!=1){
                for(char k:Integer.toString(count).toCharArray()){
                    chars[j++]=k;
                }
            }
        }
        return j;
    }
}