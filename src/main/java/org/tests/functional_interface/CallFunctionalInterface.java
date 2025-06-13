package org.tests.functional_interface;

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Logger;

@Slf4j
public class CallFunctionalInterface {
    private CallFunctionalInterface() {
    }

    public static final FInterface result = (x, y) -> x ^ y;

    public static void call(int x, int y) {
        log.info(String.valueOf(result.multiply(x, y)));
    }

}

