package twoSumInputArrayIsSorted;

import java.util.Arrays;

public class TwoSumInputArrayIsSorted {
    public static void main(String[] args) {

        //int[] nums = {1,1,0,0,1,1,1,1,0,1,1,0,0,0,1};
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new Solution().twoSum(nums, 9)));
    }
}

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[right] + numbers[left] > target) {
                right--;
            } else if (numbers[right] + numbers[left] < target) {
                left++;
            } else {
                break;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
