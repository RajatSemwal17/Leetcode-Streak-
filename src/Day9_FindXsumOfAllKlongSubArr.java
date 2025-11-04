import java.util.*;

class Solution9 {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int ind = 0;
        for(int i=0;i<n-k+1;i++){
            HashMap<Integer, Integer> mpp = new HashMap<>();
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                mpp.put(nums[j], mpp.getOrDefault(nums[j], 0) + 1);
            }

            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(mpp.entrySet());
            list.sort((a,b) -> {
                if(b.getValue().equals(a.getValue())){
                    return b.getKey() - a.getKey();
                }
                return b.getValue() - a.getValue();
            });

            int temp = x;
            for(Map.Entry<Integer, Integer> entry : list){
                if(temp!=0){
                    sum += entry.getKey() * entry.getValue();
                    temp--;
                }
                else{
                    break;
                }
            }
            result[ind++] = sum;
        }
        return result;
    }
}