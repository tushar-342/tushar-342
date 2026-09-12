class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (x,y) -> Integer.compare(x[0], y[0]));
        List<int[]> result = new ArrayList<>();
        int start1 = intervals[0][0];
        int end1 = intervals[0][1];
        for(int i=0; i<n; i++){
            int start2 = intervals[i][0];
            int end2 = intervals[i][1];
            if(start2 <= end1){ //overlapping
                start1 = start1;
                end1 = Math.max(end1, end2);
            }else{
                result.add(new int[] {start1, end1});
                start1 = start2;
                end1 = end2;
            }
        }
        result.add(new int[] {start1, end1});
        return result.toArray(new int[result.size()][]);
    }
}