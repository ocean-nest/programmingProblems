package home.random;
import java.util.*;

public class LongestStreakArr {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");

        String[] times = {"100", "150", "250", "300", "130", "80", "300", "400", "500"};
        int threshold = 200;

        List<String> longest_streak = find_longest_streak(times, threshold);
        System.out.println("The longest streak is: " + longest_streak);
        // Expected output is 3
    }

    public static List<String> find_longest_streak(String[] times, int threshold) {
        int max_streak = 0;
        int tempThreshold = 0;
        int lastIndex = 0;

        for(int i=0; i<times.length; i++) {
            if(Integer.parseInt(times[i]) >= threshold) {
                tempThreshold++;
                if(tempThreshold >= max_streak)
                    lastIndex = i;
                max_streak = tempThreshold;
            }
            else {
                tempThreshold=0;
            }
        }

        List<String> list = new ArrayList<>();
        for(int i = lastIndex - max_streak + 1; i <= lastIndex; i++ ) {
            list.add(String.valueOf(times[i]));
        }

        return list;
    }
}
