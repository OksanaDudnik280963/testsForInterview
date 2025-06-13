package org.tests.threads;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
@Slf4j
public class CyclicBarrierExercise {
    private static final int NUM_THREADS = 3;
    private static final CyclicBarrier barrier = new CyclicBarrier(NUM_THREADS, new BarrierAction());

    public static void main(String[] args) {
        Thread[] threads = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            threads[i] = new Thread(new Worker());
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
        @Override
        public void run() {
            try {
                log.info("Thread " + Thread.currentThread().getName() + " is waiting at the barrier.");
                barrier.await();

                // Perform work after reaching the barrier

                log.info("Thread " + Thread.currentThread().getName() + " has crossed the barrier and continued execution.");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    static class BarrierAction implements Runnable {
        @Override
        public void run() {
            log.info("Barrier reached! All threads have arrived at the barrier.");
        }
    }
}