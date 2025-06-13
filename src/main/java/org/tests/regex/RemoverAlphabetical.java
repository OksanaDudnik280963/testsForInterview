package org.tests.regex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoverAlphabetical {
    public static void main(String[] args) {
        String text = "Java Exercises";
        log.info("Original string: " + text);
        log.info("After removing all non-alphanumeric characters from the said string: " + validate(text));
        text = "Ex@^%&%(ercis*&)&es";
        log.info("\nOriginal string: " + text);
        log.info("After removing all non-alphanumeric characters from the said string: " + validate(text));
    }

    public static String validate(String text) {
        return text.replaceAll("(?i)[^A-Z]", "");
        ////text.replaceAll("[^a-zA-Z]", "");
    }
}