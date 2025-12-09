package home.random;

import java.util.ArrayList;
import java.util.List;

public class LongestNiceString {

    public static void main(String[] args) {
        String s = "earthproblem";

        int left = 0;

        int vowCount = 0;
        int conCount = 0;

        int max = 0;
        boolean[] bool = new boolean[26];

        int maxRight = 0;
        int currmax = 0;

        for(int right=0; right<s.length(); right++) {

            char rightChar = s.charAt(right);
            int index = rightChar - 'a';

            while(bool[index]) {
                char leftChar = s.charAt(left);
                int leftIdx = leftChar - 'a';
                bool[leftIdx] = false;

                if(isVowel(leftChar)) vowCount--;
                else conCount--;

                left++;
            }

            bool[index] = true;

            if(isVowel(rightChar)) vowCount++;
            else conCount++;

            if(vowCount>0 && conCount>0) {
                currmax = right - left + 1;
                if (currmax > max) {
                    max = currmax;
                    maxRight = right;
                }
            }
        }

        System.out.println("Longest length is = " + max);

        StringBuilder sb = new StringBuilder();
        for(int i = maxRight-max+1; i <= maxRight; i++) {
            sb.append(s.charAt(i));
        }

        System.out.println("Longest string is: " + sb);
    }

    public static boolean isVowel(char c) {
        return (c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u');
    }

}

