package leetcode.array.containerMostWater;

public class ContainerMostWater {
    public static void main(String args[]) {

        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(nums));
    }
}
class Solution {
    public int maxArea(int[] height) {

        int maxArea = 0;
        int left = 0;
        int right=height.length-1;

        while(right>left) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));
            if(height[left] > height[right]) {
                right--;
            }
            else {
                left ++;
            }


        }
        return maxArea;
    }
}

