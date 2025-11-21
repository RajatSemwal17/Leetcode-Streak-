package Streak_2;

import java.util.*;

class Solution14 {

    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];

        Arrays.fill(left,-1);
        Arrays.fill(right,-1);

        for(int i=0;i<n;i++){
            int curr = s.charAt(i)-'a';
            if(left[curr] == -1){
                left[curr] = i;
            }
            right[curr] = i;
        }

        int count = 0;
        for(int i=0;i<26;i++){
            if(left[i] == -1) continue;
            Set<Character> st = new HashSet<>();
            for(int j=left[i]+1;j<right[i];j++){
                st.add(s.charAt(j));
            }
            count += st.size();
        }
        return count;
    }
}
