package Streak_2;

//1513. Number of Substrings With Only 1s

class Solution9 {
    public int numSub(String s) {
        int n = s.length();
        int count = 0;
        int i = 0;
        long mod = 1000000007;
        while(i<n){
            if(s.charAt(i) == '1'){
                int j = i;
                while(j<n && s.charAt(j) == '1'){
                    j++;
                }
                int len = j-i;
                count = (int) ((count + (long) len*(len+1) / 2)%mod);
                i = j;
            }
            else{
                i++;
            }
        }
        return count;
    }
}
