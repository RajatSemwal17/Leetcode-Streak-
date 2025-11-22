package Streak_2;

//3190. Find Minimum Operations to Make All Elements Divisible by Three

class Solution15 {
    public int minimumOperations(int[] nums) {
        int count = 0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i] % 3 == 0){
                continue;
            }
            else{
                int next = nums[i]+1;
                int prev = nums[i]-1;
                if(next%3 == 0){
                    count++;
                }
                else{
                    count++;
                }
            }
        }
        return count;
    }
}
