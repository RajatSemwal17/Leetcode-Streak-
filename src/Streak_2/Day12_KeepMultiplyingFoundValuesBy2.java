package Streak_2;

import java.util.*;

//2154. Keep Multiplying Found Values by Two

class Solution12 {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        // Arrays.sort(nums);
        Set<Integer> st = new HashSet<>();
        for(int num : nums){
            st.add(num);
        }
        while(st.contains(original)){
            original = original << 1;
        }
        return original;
    }
}
