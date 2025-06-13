package org.tests.fibonacci;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Level;
import java.util.logging.Logger;
@Slf4j
public class PrintFibonacciRecursive {
    private static final Logger logger = Logger.getLogger(PrintFibonacciRecursive.class.getName());
    private PrintFibonacciRecursive() {
    }

    private static int fibonacci(int count) {
        if (count <= 1)
            return count;

        return fibonacci(count - 1) + fibonacci(count - 2);
    }

    public static void printFibonacciWithRecurse() {

        int seqLength = 10;

        log.info("A Fibonacci sequence of " + seqLength + " numbers: ");
        if(logger.isLoggable(Level.ALL)){
            logger.info("\n\r");
            logger.info(" A Fibonacci sequence of " + seqLength + " numbers: ");
        }

        for (int i = 0; i < seqLength; i++) {
            log.info(fibonacci(i) + " ");
            if(logger.isLoggable(Level.ALL)){
                logger.info(fibonacci(i) + " ");
            }

        }
    }
}
