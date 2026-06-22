package cursor.questions.rateLimiter;

public class SimpleRateLimiter {
    private final int maxRequestPerSecond;

    private int currentRequests = 0;
    private long currentWindowTimestamp = 0;
    public SimpleRateLimiter(int maxRequestPerSecond) {
        this.maxRequestPerSecond = maxRequestPerSecond;
    }
    public synchronized boolean acquire() {
        long now = System.currentTimeMillis()/100;
        if(now == currentWindowTimestamp) {
            if(currentRequests < maxRequestPerSecond) {
                currentRequests ++;
                return true;
            }
            return false;
        }
        else {
            currentWindowTimestamp = now;
            currentRequests = 1;
            return true;
        }
    }
}
