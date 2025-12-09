package home.random;


import java.util.*;
public class StringPrintWords {
    public static void main(String[] args) {
        String question = "ab12cde3xyz40jk";

        List<String> result = findBlocks(question);
        System.out.println("The answer is: " + result); //expected = 4
    }

    public static List<String> findBlocks(String s) {
        boolean isBlock = false;
        List<String> list = new ArrayList<>();
        String str="";
        for(char c:s.toCharArray()) {
            if(Character.isLetter(c)) {
                str += c+"";
                isBlock = true;

            }
            else {
                if(isBlock) {
                    isBlock = false;
                    list.add(str);
                    str="";
                }
            }
        }
        if(isBlock) list.add(str);

        return list;
    }

}
