package Streak_2;

//717. 1-bit and 2-bit Characters

class Solution11 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while(i<n-1){
            i += bits[i]+1;
        }
        return i == n-1;
    }
}