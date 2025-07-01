package findDupNumber;

public class FindDupNumber {
    public static void main(String[] args) {

        int[] num = {1, 3, 4, 2, 2};
        System.out.println(new Solution().findDuplicate(num));
    }
}
class Solution {
    public int findDuplicate(int[] nums) {

        int slowPointer = nums[0];
        int fastPointer = nums[0];
        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while (slowPointer != fastPointer);

        int slowPointer2 = nums[0];

        while(slowPointer != slowPointer2) {
            slowPointer = nums[slowPointer];
            slowPointer2 = nums[slowPointer2];
        }
        return slowPointer;
    }
}

