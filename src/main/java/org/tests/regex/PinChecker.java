package org.tests.regex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PinChecker {
    public static final String PIN = "Original PIN Number: ";
    public static final String IS_PIN_VALID = "Is the said PIN number is valid? ";

    public static void main(String[] args) {
        String n = "123";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
        n = "1234";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
        n = "12345";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
        n = "123456";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
        n = "1234567";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
        n = "12345678";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
        n = "123456789";
        log.info(PIN + n);
        log.info(IS_PIN_VALID + validate(n));
    }

    public static boolean validate(String n) {
        return n.matches("\\d{4}|\\d{6}|\\d{8}");
    }
}
