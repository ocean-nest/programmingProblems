package home.random;

public class LongestNiceStringLength {

    public static void main(String[] args) {
        String s = "earthproblem";

        int left = 0;
        int right = 0;

        int vowCount = 0;
        int conCount = 0;

        int max = 0;
        boolean[] bool = new boolean[26];

        for(right=0; right<s.length(); right++) {

            int index = s.charAt(right) - 'a';

            while(bool[index]) {
                int leftIdx = s.charAt(left) - 'a';
                bool[leftIdx] = false;
                if(isVowel(s.charAt(left))){
                    vowCount--;
                } else {
                    conCount--;
                }
                left++;
            }

            bool[index] = true;
            if(isVowel(s.charAt(right))){
                vowCount++;
            } else {
                conCount++;
            }
            if(vowCount>0 && conCount>0)
                max = Math.max(max, (right-left+1));

        }
        System.out.println("Max is = "+max);
    }

    public static boolean isVowel(char c) {
        return (c=='a'|| c=='e'|| c=='i'|| c=='o'|| c=='u');
    }

}
