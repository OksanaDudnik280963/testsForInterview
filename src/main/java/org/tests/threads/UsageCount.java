package org.tests.threads;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
@Slf4j
public class UsageCount {
        private static final int NUM_THREADS = 3;
        private static final CountDownLatch startLatch = new CountDownLatch(1);
        private static final CountDownLatch finishLatch = new CountDownLatch(NUM_THREADS);

        public static void main(String[] args) {
            Thread[] threads = new Thread[NUM_THREADS];
            for (int i = 0; i < NUM_THREADS; i++) {
                threads[i] = new Thread(new Worker());
                threads[i].start();
            }

            // Allow threads to start simultaneously
            startLatch.countDown();

            try {
                finishLatch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }

            log.info("All threads have finished their work.");
        }

        static class Worker implements Runnable {
            @Override
            public void run() {
                try {
                    startLatch.await();

                    // Perform work

                    log.info("Thread " + Thread.currentThread().getName() + " has finished its work.");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                } finally {
                    finishLatch.countDown();
                }
            }
        }
    }