package home.random;


public class StringProduct {
    public static void main(String[] args) {
        String oldQuestion = "ab12c3xyz40";
        String question = "abcxyz";

        int result = findProduct(oldQuestion);
        System.out.println("The product is: " + result); //expected = 55
    }

    public static int findProduct(String s) {

        char[] charr = s.toCharArray();
        int product = 1;
        int cur = 0;

        for(char c: charr) {
            if(Character.isDigit(c)) {
                cur = cur*10 + c - '0';
            }
            else {
                if(cur !=0) product*=cur;
                cur = 0;
            }
        }

        if(cur !=0) product*=cur;
        return product;
    }
}
