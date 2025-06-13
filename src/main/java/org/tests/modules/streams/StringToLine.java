package org.tests.modules.streams;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@Slf4j
public class StringToLine {
    private static final Logger logger = Logger.getLogger(StringToLine.class.getName());
    public static void main(String[] args) {
        String[] arr = {"Rttuuu", "Ighffdd TTTTTYYy", "IIUIUIUIUIUljljllll", null, "    ", "mnmmmYTHTYUTUt"};
        List<String> list = Arrays.asList(arr);
        List<String> newLines = list.stream()
                .filter(Objects::nonNull)
                .filter(x -> !x.isEmpty())
                .sorted()
                .toList();
        newLines.forEach(logger::info);//"Rttuuu", "Ighffdd TTTTTYYy", "IIUIUIUIUIUljljllll", "mnmmmYTHTYUTUt"

        List<String> manyLines = newLines.stream()
                .map(x -> {
                    String y = x.substring(0, 1);
                    String z = x.substring(1);
                    x = y.toUpperCase().concat(z.toLowerCase());
                    return x;
                })
                .sorted()
                .toList();

        manyLines.forEach(x -> logger.info("x=" + x + "!"));
        String result = String.join(" ", manyLines);
        logger.info(result);

    }

}
