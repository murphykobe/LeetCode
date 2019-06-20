class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length<=1) return intervals;
        
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1[0],i2[0]));
        
        List<int[]> res=new ArrayList<>();
        
        int start=intervals[0][0];
        int end=intervals[0][1];
        
        for(int[] n:intervals){
            if(n[0]<=end){
                end=Math.max(n[1],end);
            }else{
                res.add(new int[]{start,end});
                start=n[0];
                end=n[1];
            }
        }
        
        res.add(new int[]{start,end});
        return res.toArray(new int[0][]);
    }
}