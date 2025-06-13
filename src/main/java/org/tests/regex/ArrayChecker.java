package org.tests.regex;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class ArrayChecker {

    public static void main(String[] args) {

        log.info(String.valueOf(validate("ABCDEFabcdef123450")));
        log.info(String.valueOf(validate("SQL")));
        log.info(String.valueOf(validate("Java")));
        log.info(String.valueOf(validate("*&%@#!}{")));
        log.info(String.valueOf(validate("w3resource.com")));
    }

    public static boolean validate(String text) {
        return text.matches("^[\\w]+$");
    }
}