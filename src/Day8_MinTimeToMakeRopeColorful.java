//1578. Minimum Time to Make Rope Colorful

class Solution8 {
    public int minCost(String colors, int[] neededTime) {
        int count = 0;
        for(int i=1;i<colors.length();i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                count += Math.min(neededTime[i], neededTime[i-1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i-1]);
            }
        }
        return count;
    }
}