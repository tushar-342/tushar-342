class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((e1, e2) -> {
            return e2[0] - e1[0];
        });
        for(int i=0; i<points.length; i++){
            int[] point = points[i];
            int x = point[0], y = point[1];
            int dist = (x*x) + (y*y);
            maxHeap.add(new int[]{
                dist, i
            });
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }

        int[][] res = new int[k][2];
        int i=0;
        while(i<k){
            int[] ele = maxHeap.poll();
            int dist = ele[0], coordIdx = ele[1];
            res[i][0] = points[coordIdx][0];
            res[i][1] = points[coordIdx][1];
            i++;
        }
        return res;
    }
}