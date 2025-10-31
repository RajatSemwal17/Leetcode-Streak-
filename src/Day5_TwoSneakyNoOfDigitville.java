// 3289. The Two Sneaky Numbers of Digitville

class Solution5 {
    public int[] getSneakyNumbers(int[] nums) {
        // HashMap<Integer,Integer> mpp = new HashMap<>();
        // for(int it : nums){
        //     mpp.put(it, mpp.getOrDefault(it,0) + 1);
        // }
        // int[] res = new int[2];
        // int i=0;
        // for(Map.Entry<Integer,Integer> entry : mpp.entrySet()){
        //     if(entry.getValue() == 2){
        //         res[i++] = entry.getKey();
        //     }
        // }
        // return res;



//        best time complexity:

        int[] res = new int[2];
        int cnt = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    res[cnt] = nums[i];
                    cnt++;
                    break;
                }
            }
        }
        return res;
    }
}