package org.tests.big_decimal;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
@Deprecated
public class Test {
    public static void main(String[] args) {
        float x = 451.3256412f;

        int decimalPlace = 4;
        BigDecimal bdNum = new BigDecimal(Float.toString(x));
        bdNum.setScale(decimalPlace, RoundingMode.HALF_UP);
        log.info(String.format("Original number: %.7f \n", x));
        log.info("Rounded upto 4 decimal: " + bdNum);
    }
}
