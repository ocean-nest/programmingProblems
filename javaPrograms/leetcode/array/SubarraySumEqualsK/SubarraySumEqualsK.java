package SubarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {

        //int[] nums = {1,1,0,0,1,1,1,1,0,1,1,0,0,0,1};
        int[] nums = {1,1,1,1,1,1,1};
        System.out.println(new Solution().subarraySum(nums, 3));
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int kcount = 0;
        int counter = 0;


        for (int i: nums ) {
            counter += i;

            if(map.containsKey(counter-k)) {
                kcount += map.get(counter-k);
            }

            map.put(counter, map.getOrDefault(counter, 0) + 1);
        }

        System.out.println(map);

        return kcount;
    }
}

