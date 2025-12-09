package home.random;

public class LongestStreak {
    public static void main(String[] args) {

        String[] times = {"100", "150", "250", "300", "130", "80", "300", "400", "500"};
        int threshold = 200;

        int longest_streak = find_longest_streak(times, threshold);
        System.out.println("The longest streak is: " + longest_streak);
        // Expected output is 3
    }

    public static int find_longest_streak(String[] times, int threshold) {
        int max_streak = 0;
        int tempThreshold = 0;

        for (String time : times) {
            if (Integer.parseInt(time) >= threshold) {
                tempThreshold += 1;
                max_streak = Math.max(tempThreshold, max_streak);
            } else
                tempThreshold = 0;
        }
        return max_streak;
    }
}

