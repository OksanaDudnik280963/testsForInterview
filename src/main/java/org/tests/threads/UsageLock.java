package org.tests.threads;

// SharedResourceExercise.java
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.interrupted;
@Slf4j
public class UsageLock {
    private static final int NUM_THREADS = 3;
    private static final int NUM_ITERATIONS = 5;

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        SharedResource sharedResource = new SharedResource();

        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker(lock, sharedResource));
            threads[i].start();
        }

        try {
            for (Thread thread: threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    static class Worker implements Runnable {
        private final Lock lock;
        private final SharedResource sharedResource;

        public Worker(Lock lock, SharedResource sharedResource) {
            this.lock = lock;
            this.sharedResource = sharedResource;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUM_ITERATIONS; i++) {
                this.lock.lock();
                try {
                    this.sharedResource.doWork();
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }

    static class SharedResource {
        public void doWork() {
            String threadName = Thread.currentThread().getName();
            log.info("Thread-> " + threadName + " is performing work.");
            // Perform work on the shared resource
        }
    }
}