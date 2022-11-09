package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        //1
        MyList<Integer> integers = new MyList<>();
        System.out.println("\nintegers.size: " + integers.size() + "\n");

        for (int i = 0; i < 10; i++) {
            integers.add(new Random().nextInt());
        }
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("integers.add: " + integers.get(i) + " (index = " + i + ")");
        }
        System.out.println("\nintegers.size: " + integers.size() + "\n");

        System.out.println("integers remove: " + integers.remove(new Random().nextInt(integers.size())) + "\n");

        for (int i = 0; i < integers.size(); i++) {
            System.out.println("integers.add: " + integers.get(i) + " (index = " + i + ")");
        }
        System.out.println("\nintegers.size: " + integers.size() + "\n");

        //2
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        List<Double> list2 = list.stream().map(Integer::doubleValue).toList();
        System.out.println(list2);

    }
}
