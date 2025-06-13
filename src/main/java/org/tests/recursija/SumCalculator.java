package org.tests.recursija;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SumCalculator {

    public static int calculateSum(int n) {
        // Base case: sum of 0 is 0
        if (n == 0) {
            return 0;
        }

        // Recursive case: add n with the sum of (n-1)
        return n + calculateSum(n - 1);
    }

    public static void main(String[] args) {
        int number = 7;
        int sum = calculateSum(number);
        log.info("Sum of numbers from 1 to " + number + " is: " + sum);
    }
}
