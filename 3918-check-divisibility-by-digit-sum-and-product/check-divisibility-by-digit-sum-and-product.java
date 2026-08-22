class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int product = 1;
        int originalN = n;
        int totalSum = 0;
        while(n > 0){
            int remainder = n%10;
            n /= 10;
            sum += remainder;
            product *= remainder;
        }
        totalSum = sum + product;
        if(originalN % totalSum != 0) return false;
        return true;
    }
}