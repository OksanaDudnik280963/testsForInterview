package org.tests.modules.streams;

import java.util.Arrays;
import java.util.List;

public class Filtered {
    public static void main(String[] args){
        List currentList = Arrays.asList(6,8,12,14,19,2,4,6,12);
        List filteredList = currentList.stream()
                .distinct()
                .sorted()
                .toList();
        for (int i = 0; i <filteredList.size() ; i++) {
            System.out.println(String.valueOf(filteredList.get(i)));
        }


    }
}
