package Streak_2;
import java.util.*;
//3542. Minimum Operations to Convert All Elements to Zero

class Solution3 {
    public int minOperations(int[] nums) {
        int count = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int num : nums){
            while(!st.isEmpty() && st.peek() > num){
                st.pop();
            }
            if(st.isEmpty() || st.peek() < num){
                st.push(num);
                count++;
            }
        }
        return count;
    }
}