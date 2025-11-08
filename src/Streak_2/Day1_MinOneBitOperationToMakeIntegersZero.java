package Streak_2;

//1611. Minimum One Bit Operations to Make Integers Zero

class Solution1 {
    public int minimumOneBitOperations(int n) {
        int mask = n;
        while(mask!=0){
            mask = mask >> 1;
            n = n^mask;
        }
        return n;
    }
}