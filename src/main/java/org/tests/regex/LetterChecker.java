package org.tests.regex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LetterChecker {
        public static void main(String[] args) {

            log.info(validate("phkuyrt"));
            log.info(validate("pq"));
            log.info(validate("pccddbbjjjq"));
            log.info(validate("Jar"));
            log.info(validate("pjhut"));
        }

        public static String validate(String text) {
            if (text.matches("p.*?q$"))
                return "Found a match!";
            else
                return "Not matched!";
        }
    }
