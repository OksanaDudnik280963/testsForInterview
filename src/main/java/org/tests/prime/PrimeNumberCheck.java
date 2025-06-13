package org.tests.prime;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Level;
import java.util.logging.Logger;
@Slf4j
public class PrimeNumberCheck {
    private static final Logger logger = Logger.getLogger(PrimeNumberCheck.class.getName());
    public static void main(String[] args) {
        log.info(isPrime(19)); // true
        log.info(isPrime(49)); // false

        if(logger.isLoggable(Level.ALL)) {
            logger.info(isPrime(19));
            logger.info(isPrime(49));
        }
    }

    public static String isPrime(int n) {
        if (n == 0 || n == 1) {
            return "false";
        }
        if (n == 2) {
            return "true";
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return "false";
            }
        }

        return "true";
    }
}
