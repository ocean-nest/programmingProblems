package happyNumber.recursion;

import java.util.HashSet;
import java.util.Set;

public class HappyNumberRecursion {
    public static void main(String args[]) {

        int num = 15353670;
        System.out.println(new Solution().isHappy(num));
    }
}

class Solution {
    public boolean isHappy(int n) {
        return compute(new HashSet<>(), String.valueOf(n).toCharArray());
    }

    boolean compute(Set<String> set, char[] carray) {
        long sum = 0;
        for(int i=0; i<carray.length; i++) {
            int val = Character.getNumericValue(carray[i]);
            val *= val;
            sum += val;
        }
        if(sum==1) {
            return true;
        }
        else if(set.contains(String.valueOf(sum))) {
            return false;
        }
        set.add(String.valueOf(sum));
        return compute(set, String.valueOf(sum).toCharArray());
    }
}