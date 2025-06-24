package contiguousArray;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String args[]) {

        int[] nums = {1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1};
        System.out.println(new Sloution().findMaxLength(nums));
    }

}

class Sloution {
    public int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLength = 0;
        int counter = 0;


        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }

            if (map.containsKey(counter)) {
                maxLength = Math.max(i - map.get(counter), maxLength);
            } else {
                map.put(counter, i);
            }
        }

        return maxLength;


    }
}
