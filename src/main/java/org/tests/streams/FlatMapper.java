package org.tests.streams;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class FlatMapper {
    public static void main(String[] args){
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

    }
    @Getter
    static class Order  {
        List<Product> products;
        double totalPrice;

        public Order(List<Product> products) {
            this.products = products;
            calculateTotalPrice(products);
        }

        private void calculateTotalPrice(List<Product> products) {
            for(Product product : products) {
                totalPrice += product.price();
            }



        }

    }

    record Product (String name, int price) {
    }
}
