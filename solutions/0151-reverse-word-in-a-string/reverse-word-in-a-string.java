class Solution {
    public String reverseWords(String s) {
        String[] n=s.trim().split(" +");
        int i=0;
        int j=n.length-1;
        while(i<j){
            String temp=n[i];
            n[i]=n[j];
            n[j]=temp;
            i++;
            j--;
        }
        return String.join(" ",n);
    }
}