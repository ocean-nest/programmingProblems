package happyNumber.slowFastPointer;

public class HappyNumber {
    public static void main(String[] args) {

        int num = 19;

        System.out.println(isHappyNumber(num));
    }
    public static boolean isHappyNumber(int n) {
        int slowPointer = n;
        int fastPointer = n;
        do {
            slowPointer = square(slowPointer);
            fastPointer = square(square(fastPointer));
        } while(slowPointer != fastPointer);

        return slowPointer == 1;

    }

    public static int square(int number) {
        int sum = 0;

        while(number > 0) {
            int right = number % 10;
            sum = sum + (right * right);
            number /= 10;
        }
        return sum;
    }
}


class SolutionHappyNumber {
    public boolean isHappyNumber(int n) {
        int slowPointer = n;
        int fastPointer = n;
        do {
            slowPointer = square(slowPointer);
            fastPointer = square(square(fastPointer));
        } while(slowPointer != fastPointer);

        return slowPointer == 1;

    }

    public int square(int number) {
        int sum = 0;

        while(number > 0) {
            int right = number % 10;
            sum = sum + (right * right);
            number /= 10;
        }
        return sum;
    }

}
