//3354 -> Make Array Elements Equal to Zero

class Solution {
    public int countValidSelections(int[] nums) {
        int sum=0;
        for(int it : nums){
            sum+=it;
        }
        int ans = 0;
        int n = nums.length;
        int prefix = 0;
        int suffix = sum;
        for(int i=0;i<n;i++){
            prefix += nums[i];
            suffix -= nums[i];
            if(nums[i] > 0) continue;
            if(prefix == suffix) ans += 2;
            if(Math.abs(prefix-suffix) == 1) ans += 1;
        }
        return ans;
    }
}