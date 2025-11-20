package Streak_2;

//757. Set Intersection Size At Least Two

import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[1] == b[1] ? b[0] - a[0] :  a[1] - b[1]);
        int secondlast = -1;
        int last = -1;
        int result = 0;

        for(int[] interval : intervals){
            int start = interval[0];
            int end = interval[1];

            if(start <= secondlast){
                continue;
            }

            if(start > last){
                result += 2;
                last = end;
                secondlast = end-1;
            }
            else{
                result += 1;
                secondlast = last;
                last = end;
            }
        }

        return result;
    }
}