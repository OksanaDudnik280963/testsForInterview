package org.tests.regex;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IPChecker {

        public static void main(String[] args) {

            log.info(validate("216.08.094.196"));
            log.info(validate("08.008.0008.00008"));
            log.info(validate("01.102.103.104"));
        }

        public static String validate(String ip) {
            return ip.replaceAll("(?<=^|\\.)0+(?!\\.|$)","");
        }
    }

