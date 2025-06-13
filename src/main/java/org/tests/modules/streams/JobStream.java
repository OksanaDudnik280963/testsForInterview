package org.tests.modules.streams;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;


import static java.util.Arrays.asList;

@Slf4j
public class JobStream {
    private JobStream() {
    }

    public static void reduceUsage() {
        List<Integer> numbers = asList(1, 2, 3, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce(Integer::sum);

        sum.ifPresent(i->log.info(String.valueOf(i))); //output 11
    }

    public static void min() {
        List<Integer> numbers = asList(1, 2, 3, 5, 7);

        Integer min = numbers.stream()
                .reduce(Integer.MAX_VALUE, Integer::min);

        log.info(String.valueOf(min)); //output
    }

    public static void primitivesAverage() {
        OptionalDouble intAverage = IntStream.of(1, 2).average(); // 1.5
        OptionalDouble longAverage = LongStream.of(3, 4).average(); // 3.5
        OptionalDouble doubleAverage = DoubleStream.of(5, 6).average(); // 5.5
        log.info(intAverage + " " + longAverage + " " + doubleAverage);
    }

    public static void filters() {
        IntStream.of(1, 3, 5, 7, 9)
                .filter(i -> i > 3)
                .forEach(i->log.info(String.valueOf(i))); //output 5 7 9
    }

    @Getter
    static class Human {
        private final String name;
        private final List<String> pets;

        Human(String name, List<String> pets) {
            this.name = name;
            this.pets = pets;
        }
    }

    public static void flatMap() {

        List<Human> humans = asList(
                new Human("Sam", asList("Buddy", "Lucy")),
                new Human("Bob", asList("Frankie", "Rosie")),
                new Human("Marta", asList("Simba", "Tilly")));

        List<String> petNames;
        petNames = humans.stream()
                .map(Human::getPets) //преобразовываем Stream<Human> в Stream<List<Pet>>
                .flatMap(Collection::stream)//"разворачиваем" Stream<List<Pet>> в Stream<Pet>
                .toList();

        log.info(petNames.toString()); // output [Buddy, Lucy, Frankie, Rosie, Simba, Tilly]
        int[][] arr = {{1, 2}, {3, 4}, {5, 6}};

        int[] newArr = Arrays.stream(arr)
                .flatMapToInt(Arrays::stream) //преобразовываем IntStream<int[]> в IntStream
                .toArray(); // преобразовываем IntStream в int[]

        log.info(Arrays.toString(newArr)); //output [1, 2, 3, 4, 5, 6]
    }

    private static final Map<String, String> humans = Map.of(
            "John", "Snow",
            "Aria", "Stark",
            "Daenerys", "Targaryen"
    );

    private static Optional<String> getSurname(String name) {
        return Optional.ofNullable(humans.get(name));
    }

    public static void test() {
        List<String> names = List.of("John", "Aria", "Tyrion", "Daenerys", "Eddard");
        names.stream()
                .map(JobStream::getSurname)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(log::info);
    }

    public static void dublicates() {
        List<Integer> integers = Arrays.asList(11, 12, 11, 13, 15, 15);
        Set<Integer> integerSet = new HashSet<>();
        integers.stream().filter(integerSet::add).forEach(x-> log.info(x+" "));
        log.info("\n\r");

        integers.stream().filter(x -> !integerSet.add(x)).forEach(x -> log.info(x + " "));
        log.info("\n\r");

        integers.stream().filter(x-> !integerSet.add(x)).collect(Collectors.toSet()).forEach(x-> log.info(x+" "));

    }

    public static void testStream() {
        List<Integer> integers = Arrays.asList(1, 3, 5, 6, 7, 8, 9, 33, 4, 55, 77);
        integers.stream().skip(4).forEach(x -> log.info(x + " "));
        log.info("\r\n");
        integers.stream().limit(4).forEach(x -> log.info(x + " "));
    }

    public static void testGrouping() {
        String str = "Welcome to code decode and code decode welcome you";
        log.info(str);
        List<String> ss = Arrays.asList(str.split(" "));
        Map<String, Long> map = ss.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        log.info(map.toString());
    }

    public static void testSmallestLargestDigit() {
        List<Integer> nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);
        log.info("List of numbers: " + nums);
        // Find the second smallest element
        Integer secondSmallest = nums.stream()
                .distinct()
                .sorted()
                .skip(1)
                .findFirst()
                .orElse(null);

        // Find the second largest element
        Integer secondLargest = nums.stream()
                .distinct()
                .sorted((a, b) -> Integer.compare(b, a))
                .skip(1)
                .findFirst()
                .orElse(null);

        log.info("\nSecond smallest element: " + secondSmallest);
        log.info("\nSecond largest element: " + secondLargest);
    }
}
