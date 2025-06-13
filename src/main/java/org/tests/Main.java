package org.tests;

import lombok.extern.slf4j.Slf4j;
import org.tests.threads.CustomThread;

import static org.tests.fibonacci.PrintFibonacci.printFibonacciSequence;
import static org.tests.fibonacci.PrintFibonacciRecursive.printFibonacciWithRecurse;
import static org.tests.functional_interface.CallFunctionalInterface.call;
import static org.tests.modules.streams.JobStream.*;
import static org.tests.odd.OddNumbers.printOddResults;
import static org.tests.prime.PrimeNumberCheck.isPrime;
@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("Hello World!");
        //prime
        log.info(isPrime(19)); // true
        log.info(isPrime(49)); // false
        //fibonacci
        log.info("====== fibonacci==============");
        printFibonacciSequence(10);
        printFibonacciWithRecurse();
        //odd
        log.info("====== odd==============");
        printOddResults();

        log.info("====== threads==============");

        CustomThread t1 = new CustomThread("Первый поток");
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
        CustomThread t2 = new CustomThread("Второй поток");
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
        CustomThread t3 = new CustomThread("Третий поток");
        t3.start();
        try {
            t3.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
        }
        //streams
        log.info("======Streams======================");
        reduceUsage();
        min();
        primitivesAverage();
        filters();
        flatMap();
        test();
        dublicates();
        log.info("======");
        call(14,23);
        call(21,123);
        testStream();
        testSmallestLargestDigit();
    }
}