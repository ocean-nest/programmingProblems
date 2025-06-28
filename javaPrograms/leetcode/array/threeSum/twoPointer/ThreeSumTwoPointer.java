package threeSum.twoPointer;

import java.util.*;

public class ThreeSumTwoPointer {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution2().threeSum(nums));
    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        int fixed = 0;

        Arrays.sort(nums);
        while (fixed <= nums.length - 3) {
            if (fixed > 0 && nums[fixed] == nums[fixed - 1]) {
                fixed++;

            }
            int left = fixed + 1;
            int right = nums.length - 1;
            while (left < right) {

                if (nums[left] + nums[right] + nums[fixed] == 0) {
                    List<Integer> innerList = Arrays.asList(new Integer[]{nums[left], nums[right], nums[fixed]});
                    Collections.sort(innerList);
                    if (!set.contains(innerList)) {
                        set.add(innerList);
                        outerList.add(innerList);
                    }
                    left++;
                    while (nums[left] == nums[left - 1] && left < right)
                        left++;


                } else if (nums[left] + nums[right] + nums[fixed] > 0) {
                    right--;
                } else {
                    left++;
                }
            }
            fixed++;
        }
        return outerList;

    }
}
