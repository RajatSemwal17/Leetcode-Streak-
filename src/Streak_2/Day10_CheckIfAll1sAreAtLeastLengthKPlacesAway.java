package Streak_2;

//1437. Check If All 1's Are at Least Length K Places Away

class Solution10 {
    public boolean kLengthApart(int[] nums, int k) {
        int n = nums.length;

//        brute approach

        // int i = 0;
        // int count = 0;
        // int mini = Integer.MAX_VALUE;
        // while(i<n && nums[i] == 0){
        //     i++;
        // }
        // if(i == n) return true;
        // i++;
        // while(i<n){
        //     int j = i;
        //     while(j<n && nums[j]!=1){
        //         count++;
        //         j++;
        //     }
        //     if(j<n && nums[i] == 1){
        //         mini = Math.min(mini, count);
        //         count = 0;
        //         i = j+1;
        //     }
        //     else{
        //         i++;
        //     }
        // }
        // if(mini>=k){
        //     return true;
        // }
        // else{
        //     return false;
        // }


        // optimal approach:

        int prev = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                if(prev!=-1 && i-prev-1 < k){
                    return false;
                }
                prev = i;
            }
        }
        return true;
    }
}
