package org.tests.streams;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class FlatMapper {
    public static void main(String[] args) {
        Product chair = new Product("Chair", 150);
        Product table = new Product("Table", 350);
        Product pencil = new Product("Pencil", 2);
        Order firstOrder = new Order(Arrays.asList(chair, table));
        Order secondOrder = new Order(Arrays.asList(pencil, chair));
        List<Order> orders = Arrays.asList(firstOrder, secondOrder);
        orders.stream()
                .flatMap(order -> order.getProducts()
                        .stream())
                .map(Product::name)
                .forEach(System.out::println);
        Order.examplesFlatMap();

    }

    @Getter
    static class Order {
        List<Product> products;
        double totalPrice;

        public Order(List<Product> products) {
            this.products = products;
            calculateTotalPrice(products);
        }

        private void calculateTotalPrice(List<Product> products) {
            for (Product product : products) {
                totalPrice += product.price();
            }
        }

        private static void examplesFlatMap() {
            Stream<String> strings = Stream.of("10000000000,20000000000", "30000000000");
            LongStream longStream = strings.flatMapToLong(s -> Arrays.stream(s.split(","))
                    .mapToLong(Long::parseLong));

            longStream.forEach(System.out::println);
//=======================================================================
            Stream<String> strings1 = Stream.of("1.1,2.2", "3.3,4.4");
            DoubleStream doubleStream = strings1.flatMapToDouble(s -> Arrays.stream(s.split(","))
                    .mapToDouble(Double::parseDouble));

            doubleStream.forEach(System.out::println);
            //================================================
            Stream.of(1, 2, 3).<String>mapMulti((number, consumer) -> {
                consumer.accept(number + "a");
                consumer.accept(number + "b");
            }).forEach(System.out::println);
        }

    }

    record Product(String name, int price) {
    }
}
