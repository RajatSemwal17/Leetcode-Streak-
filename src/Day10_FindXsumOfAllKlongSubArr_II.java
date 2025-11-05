//3321. Find X-Sum of All K-Long Subarrays II

import java.util.*;
class Solution10 {
    public TreeSet<int[]> topElements = new TreeSet<>((a,b) ->
            a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
    );

    public TreeSet<int[]> remainingElements = new TreeSet<>(topElements.comparator());

    public Map<Integer, Integer> frequencyMap = new HashMap<>();

    public long currentSum;

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] result = new long[n-k+1];

        for(int i=0;i<n;i++){
            int currentValue = nums[i];
            removeFromSets(currentValue);
            frequencyMap.merge(currentValue,1,Integer::sum);
            addToSets(currentValue);

            int windowStartIndex = i-k+1;
            if(windowStartIndex < 0){
                continue;
            }

            while(!remainingElements.isEmpty() && topElements.size()<x){
                int[] el = remainingElements.pollLast();
                currentSum += 1L * el[0] * el[1];
                topElements.add(el);
            }
            while(topElements.size()>x){
                int[] el = topElements.pollFirst();
                currentSum -= 1L * el[0] * el[1];
                remainingElements.add(el);
            }
            result[windowStartIndex] = currentSum;

            removeFromSets(nums[windowStartIndex]);
            frequencyMap.merge(nums[windowStartIndex], -1, Integer::sum);
            addToSets(nums[windowStartIndex]);
        }
        return result;
    }
    private void removeFromSets(int value){
        if(!frequencyMap.containsKey(value)){
            return;
        }
        int[] elementPair = new int[] {frequencyMap.get(value),value};

        if(topElements.contains(elementPair)){
            topElements.remove(elementPair);
            currentSum -= 1L * elementPair[0] * elementPair[1];
        }else{
            remainingElements.remove(elementPair);
        }
    }
    private void addToSets(int value){
        if(!frequencyMap.containsKey(value)){
            return;
        }
        int[] elementPair = new int[] {frequencyMap.get(value), value};

        if(!topElements.isEmpty() && topElements.comparator().compare(topElements.first(), elementPair) < 0){
            topElements.add(elementPair);
            currentSum += 1L * elementPair[0] * elementPair[1];
        } else {
            remainingElements.add(elementPair);
        }
    }
}
