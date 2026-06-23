package cursor.questions.producerConsumer;

public class ProducerConsumer {
    public static void main(String[] args) {
        BoundedBuffer<Integer> buffer = new BoundedBuffer<>(3);

        Thread producer = new Thread(() -> {
            try {
                for (int i=1; i<10; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer-Thread");

        Thread consumer = new Thread(() -> {
            try {
                for (int i=1; i<10; i++) {
                    buffer.consume();
                    Thread.sleep(400);
                }
            } catch (Exception e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer-Thread");

        producer.start();
        consumer.start();
    }
}
