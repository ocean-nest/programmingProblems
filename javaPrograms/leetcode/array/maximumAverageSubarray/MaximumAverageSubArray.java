package maximumAverageSubarray;

public class MaximumAverageSubArray {

    public static void main(String args[]) {

        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(new Solution().findMaxAverage(nums, k));
    }
}

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxSum = 0;
        int left = 0;
        int right= k-1;

        for(int i=0; i<k; i++){
            maxSum += nums[i];
        }
        double tempSum = maxSum;
        while(right < nums.length - 1) {
            tempSum = tempSum + nums[++right] - nums[left++];
            maxSum = Math.max(tempSum, maxSum);
        }
        return maxSum/k;
    }
}
