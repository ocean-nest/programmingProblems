package minumumWindowSubstring;


import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String args[]) {

        String s ="ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new Solution().minWindow(s, t));
    }
}

class Solution {
    public String minWindow(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();

        int totalLength = t.length();
        int[] solRange = {0, 9999999};
        int left = 0;

        if(t.length() > s.length())
            return "";

        for(int i = 0; i <t.length(); i++) {
            if(map.containsKey(t.charAt(i))) {
                map.put(t.charAt(i), map.get(t.charAt(i)) +1);
            }
            else
                map.put(t.charAt(i), 1);
        }
        for(int right=0; right< s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                if( map.get(s.charAt(right)) > 0) {
                    totalLength -= 1;
                }
                map.put(s.charAt(right), map.get(s.charAt(right)) -1);
            } else {
                map.put(s.charAt(right), -1);
            }

            if(totalLength == 0) {

                while(map.get(s.charAt(left)) != 0) {
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    left ++;
                }

                int tempMin = right - left + 1;
                int existingMin = solRange[1] - solRange[0] + 1;
                if(tempMin < existingMin) {
                    solRange[0] = left;
                    solRange[1] = right;
                }

                map.put(s.charAt(left), map.get(s.charAt(left)) +1);
                totalLength ++;
                left ++;
            }

        }

        StringBuffer sb = new StringBuffer();
        if(solRange[1] > s.length()) {
            return "";
        }
        for(int i = solRange[0]; i<= solRange[1]; i++)
            sb.append(s.charAt(i));

        return sb.toString();

    }
}