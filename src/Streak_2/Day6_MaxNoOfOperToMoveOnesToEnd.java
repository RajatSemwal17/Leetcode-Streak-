package Streak_2;

class Solution6 {
    public int maxOperations(String s) {
        int n = s.length();
        int count = 0;
        int ans = 0;
        int i = 0;
        while(i<n){
            if(s.charAt(i) == '1'){
                count++;
                i++;
            }
            else{
                if(count > 0){
                    ans += count;
                }
                while(i<n && s.charAt(i) == '0'){
                    i++;
                }
            }
        }
        return ans;
    }
}