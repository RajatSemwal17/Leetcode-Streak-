package Streak_2;

//1018. Binary Prefix Divisible By 5

import java.util.*;

class Solution17{
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> list = new ArrayList<>();
        int value = 0;
        for(int i=0;i<nums.length;i++){
            value = (value * 2 + nums[i]) % 5; // IMPORTANT FORMULA FOR THIS QUESTION.
            if(value == 0){
                list.add(true);
            }
            else{
                list.add(false);
            }
        }
        return list;
    }
}
