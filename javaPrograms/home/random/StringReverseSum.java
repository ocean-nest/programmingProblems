package home.random;

public class StringReverseSum {
    public static void main(String[] args) {
        String question = "ab12c3xyz40";

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
                sum+=reverse(cur);
                cur = 0;
            }
        }

        sum+=reverse(cur);

        return sum;
    }
    public static int reverse(int val) {
        int reverse = 0;

        while(val != 0) {

            int digit = val%10;
            reverse = reverse * 10 + digit;
            val/=10;
        }
        return reverse;
    }
}
