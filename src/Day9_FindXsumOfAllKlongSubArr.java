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


//MOST OPTIMAL APPPROACH:

class Solution99 {

    public int[] getXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Map<Integer, Integer> counts = new HashMap<>();

        // Build frequency map for the first window
        for (int i = 0; i < k; i++) {
            counts.put(nums[i], counts.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = calculateXSum(counts, x);

        // Slide the window
        for (int i = k; i < n; i++) {

            // Element leaving the window
            int oldElement = nums[i - k];
            counts.put(oldElement, counts.get(oldElement) - 1);
            if (counts.get(oldElement) == 0) {
                counts.remove(oldElement);
            }

            // Element entering the window
            int newElement = nums[i];
            counts.put(newElement, counts.getOrDefault(newElement, 0) + 1);

            ans[i - k + 1] = calculateXSum(counts, x);
        }

        return ans;
    }

    private int calculateXSum(Map<Integer, Integer> counts, int x) {

        // If unique elements are less than x, full sum of key*freq
        if (counts.size() < x) {
            int totalSum = 0;
            for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
                totalSum += entry.getKey() * entry.getValue();
            }
            return totalSum;
        }

        // Convert to list to sort
        List<Map.Entry<Integer, Integer>> sortedElements = new ArrayList<>(counts.entrySet());

        // Sort by frequency desc, and value desc if freq same
        sortedElements.sort((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                return b.getKey().compareTo(a.getKey()); // Value desc
            }
            return b.getValue().compareTo(a.getValue()); // Freq desc
        });

        // Pick top x elements
        Set<Integer> topXElements = new HashSet<>();
        for (int i = 0; i < x; i++) {
            topXElements.add(sortedElements.get(i).getKey());
        }

        // Calculate sum of selected elements: key * freq
        int xSum = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (topXElements.contains(entry.getKey())) {
                xSum += entry.getKey() * entry.getValue();
            }
        }

        return xSum;
    }
}
