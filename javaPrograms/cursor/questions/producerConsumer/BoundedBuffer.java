package cursor.questions.producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBuffer<T> {
    private final Queue<T> queue  = new LinkedList<>();
    private final int capacity;
    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
    }
    public synchronized void produce(T value) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(value);
        System.out.println("Produced ="+value);
        notifyAll();
    }

    public synchronized T consume() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        T value = queue.poll();
        System.out.println("Consumed = "+value);
        notifyAll();
        return value;
    }
}
