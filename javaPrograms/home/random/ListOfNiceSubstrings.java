package home.random;

import java.util.ArrayList;
import java.util.List;

public class ListOfNiceSubstrings {
    public static void main(String[] args) {
        String s = "earthproblem";
        List<String> list = listOfNiceSubStrings(s);
        System.out.println(list);
    }

    public static List<String> listOfNiceSubStrings(String s) {
        int left = 0;

        int vowCount = 0;
        int conCount = 0;

        int max = 0;
        boolean[] bool = new boolean[26];

        int maxRight = 0;
        int currmax = 0;
        List<String> list = new ArrayList<>();

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
                    list.add(returnString(s, max, maxRight));
                }
            }
        }
        return list;
    }
    public static String returnString(String s, int max, int rightMax) {
        StringBuilder sb = new StringBuilder();
        for(int i = rightMax-max+1; i <= rightMax; i++) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static boolean isVowel(char c) {
        return (c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u');
    }

}
