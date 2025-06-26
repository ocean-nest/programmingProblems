package substringWithoutRepeatChars;

import java.util.HashSet;
import java.util.Set;

public class SubstringWithoutRepeatChars {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;

        for(int right=0; right<s.length(); right ++) {
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            }
            else {
                while(set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left ++;
                }
                set.add(s.charAt(right));
            }
        }
        return maxLength;

    }
}