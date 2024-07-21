package com.neog.work.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamWork {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Pea");
        fruits.add("Grape");
        fruits.add("Mango");
        fruits.add("Pineapple");
        fruits.add("Watermelon");

        Map<Integer, List<String>> groupedByLength =
            fruits.stream().collect(Collectors.groupingBy(String :: length));

        System.out.println(groupedByLength);

        Set<String> uniqueFruits = fruits.stream()
                .collect(Collectors.toSet());

        System.out.println("Result: " + uniqueFruits);

        boolean allMatch = fruits.parallelStream()
                .allMatch(w -> w.length() > 3);

        System.out.println("All match: " + allMatch);

        List<Integer> list = Arrays.asList(10,5,8,9,6,7,5);

        Stream<Integer> stream = list.stream();
        List<Integer> collect = stream.filter(e -> e % 2 != 0).collect(Collectors.toList());
        System.out.println(collect);

        int sum = 0;
        Optional<Integer> reduce = list.stream().reduce(
                (a, b) -> a + b
        );

        System.out.println("here" + reduce.get());

        StreamWork st = new StreamWork();
        st.display();





    }

    static void display(){
        System.out.println("here call");
    }
}
