package Streak_2;

//1262. Greatest Sum Divisible by Three

import java.util.*;

class Solution16 {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int sum = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for(int num : nums){
            sum += num;
            if(num % 3 == 1) list1.add(num);
            else if(num%3 == 2) list2.add(num);
        }
        if(sum%3 == 0) return sum;
        int result = 0;
        Collections.sort(list1);
        Collections.sort(list2);

        if(sum % 3 == 1){
            int remove1 = Integer.MAX_VALUE;
            int remove2 = Integer.MAX_VALUE;
            if(!list1.isEmpty()) remove1 = list1.get(0);
            if(list2.size()>=2) remove2 = list2.get(0) + list2.get(1);
            result = sum - Math.min(remove1, remove2);
        }
        else{
            int remove1 = Integer.MAX_VALUE;
            int remove2 = Integer.MAX_VALUE;
            if(!list2.isEmpty()) remove1 = list2.get(0);
            if(list1.size()>=2) remove2 = list1.get(0) + list1.get(1);
            result = sum - Math.min(remove1, remove2);
        }
        return result;
    }
}
