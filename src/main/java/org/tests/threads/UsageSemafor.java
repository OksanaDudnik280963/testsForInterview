package org.tests.threads;




//SemaphoreExercise.java
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;
@Slf4j
public class UsageSemafor {
    private static final int NUM_THREADS = 5;
    private static final int NUM_PERMITS = 2;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(NUM_PERMITS);

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker(semaphore));
            threads[i].start();
        }

        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.info(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }

    static class Worker implements Runnable {
        private final Semaphore semaphore;

        public Worker(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                this.semaphore.acquire();

                // Perform work that requires the semaphore
                log.info("Thread " + Thread.currentThread().getName() + " acquired the semaphore.");
                Thread.sleep(2000); // Simulating work
                log.info("Thread " + Thread.currentThread().getName() + " released the semaphore.");

                this.semaphore.release();
            } catch (InterruptedException e) {
                log.info(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }
}