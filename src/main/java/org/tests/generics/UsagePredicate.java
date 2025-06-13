package org.tests.generics;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
@Slf4j
public class UsagePredicate {

    public static <T> List<T> filterList(List<T> originalList, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();

        for (T element : originalList) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        log.info("Original list of numbers: " + numbers);
        // Filter even numbers
        List<Integer> evenNumbers = filterList(numbers, n -> n % 2 == 0);
        log.info("Even numbers: " + evenNumbers);

        // Filter odd numbers
        List<Integer> oddNumbers = filterList(numbers, n -> n % 2 != 0);
        log.info("Odd numbers: " + oddNumbers);

        List<String> colors = List.of("Red", "Green", "White", "Orange", "Black", "Pink");
        log.info("\nOriginal list of Colors: " + colors);
        // Filter colors starting with 'O'
        List<String> wordsStartingWithO = filterList(colors, color -> color.startsWith("O"));
        log.info("Colors starting with 'O': " + wordsStartingWithO);

        // Filter colors with length greater than 4
        List<String> wordsLengthGreaterThan4 = filterList(colors, color -> color.length() > 4);
        log.info("Colors with length greater than 4: " + wordsLengthGreaterThan4);
    }
}


