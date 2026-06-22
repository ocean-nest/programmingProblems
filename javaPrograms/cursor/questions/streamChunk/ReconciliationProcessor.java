package cursor.questions.streamChunk;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ReconciliationProcessor {
    private static final int CHUNK_SIZE = 1000;
    private static final int THREAD_POOL_SIZE = 4;

    public void processFile(String filePath) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<String > currentChunk = new ArrayList<>(CHUNK_SIZE);

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            //skip
            String header = reader.readLine();

            while ((line = reader.readLine())!=null) {
                currentChunk.add(line);

                if(currentChunk.size() == CHUNK_SIZE) {
                    List<String> chunkToProcess = new ArrayList<>(currentChunk);
                    executor.submit(() -> processChunk(chunkToProcess));

                    currentChunk.clear();
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file:"+e.getMessage());
        }
        shutDownExecutor(executor);
    }

    private void processChunk(List<String> chunk){
        for(String row: chunk) {
            try {
                String[] columns = row.split(",");
                String transactionId = columns[0];
                double amount = Double.parseDouble(columns[1]);

                //business logic
                reconcileTransaction(transactionId, amount);
            } catch (Exception e) {
                System.err.println("Failed to process row "+ row);
            }
        }
    }
    private void reconcileTransaction(String transactionId, double amount) {
        //business logic
    }

    public void shutDownExecutor(ExecutorService executor) {
        executor.shutdown();
        try {
            if(!executor.awaitTermination(60, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
