class Solution {
    public int findDays(int[] weights, int capacity){
        int days = 1, load = 0;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > capacity){
                days++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int i=0; i<weights.length; i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }
        while(low<=high){
            int guess = low + (high - low) / 2;
            if(findDays(weights, guess) <= days){
                high = guess - 1;
            }else{
                low = guess + 1;
            }
        }
            return low;
        
    }
}