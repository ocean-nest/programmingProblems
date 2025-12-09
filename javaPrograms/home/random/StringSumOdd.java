package home.random;


public class StringSumOdd {
    public static void main(String[] args) {
        String question = "ab12c3xyz41";

        int result = findSum(question);
        System.out.println("The sum is: " + result); //expected = 55
    }

    public static int findSum(String s) {

        char[] charr = s.toCharArray();
        int sum = 0;
        int cur = 0;

        for(char c: charr) {
            if(Character.isDigit(c)) {
                cur = cur*10 + c - '0';
            }
            else {
                if(cur%2==1) sum+=cur;
                cur = 0;
            }
        }
        if(cur%2==1) sum+=cur;

        return sum;
    }
}
