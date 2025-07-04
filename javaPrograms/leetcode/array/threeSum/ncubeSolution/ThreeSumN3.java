package threeSum.ncubeSolution;

import java.util.*;

public class ThreeSumN3 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> outerList = new ArrayList<>();

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> innerList = Arrays.asList(new Integer[]{nums[i], nums[j], nums[k]});
                        Collections.sort(innerList);
                        if (!set.contains(innerList)) {
                            set.add(innerList);
                            outerList.add(innerList);
                        }
                    }
                }
            }
        }
        return outerList;

    }
}
