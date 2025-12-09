package home.random;

import java.util.*;
public class StringCountWords {
    public static void main(String[] args) {
        String question = "ab12cde3xyz40jk";

        int result = findBlocks(question);
        System.out.println("The answer is: " + result); //expected = 4
    }

    public static int findBlocks(String s) {

        char[] arr = s.toCharArray();
        int count = 0;
        boolean isBlock = false;


        for(char c:arr) {
            if(Character.isLetter(c)) isBlock = true;
            else {
                if(isBlock) {
                    count++;
                    isBlock = false;
                }
            }
        }
        if(isBlock) count++;

        return count;
    }

}
