package Streak_2;

class Solution5 {
    public int gcd(int a,int b){
        if(b == 0) return a;
        return gcd(b,a%b);
    }
    public int minOperations(int[] nums) {
        int ones = 0;
        for(int num : nums){
            if(num == 1){
                ones++;
            }
        }
        if(ones>0) return nums.length - ones;

        int mini = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int g = nums[i];
            for(int j=i+1;j<nums.length;j++){
                g = gcd(g, nums[j]);
                if(g == 1){
                    mini = Math.min(mini, j-i+1);
                    break;
                }
            }
        }
        if(mini == Integer.MAX_VALUE) return -1;
        return (nums.length-1) + (mini-1);
    }
}
