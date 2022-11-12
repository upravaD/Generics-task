package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyList<Integer> integers = new MyList<>();
        MyList<Integer>.MyIterator iterator = integers.iterator();

        //1
        System.out.println("\nintegers.size: " + integers.size() + "\n");

        //add
        integers.add(1234567890);
        for (int i = 0; i < 2; i++) {
            integers.add(new Random().nextInt());
        }

        //get
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("integers.add: " + integers.get(i) + " (index = " + i + ")");
        }
        System.out.println("\nintegers.size: " + integers.size() + "\n");

        //remove
        System.out.println("\nintegers.remove: " + integers.remove(new Random().nextInt(3)) + "\n");

        //get
        for (int i = 0; i < integers.size(); i++) {
            System.out.println("integers.add: " + integers.get(i) + " (index = " + i + ")");
        }
        System.out.println("\nintegers.size: " + integers.size() + "\n");

        //toString
        String s = integers.toString();
        System.out.println("\nintegers.toString: " + s + "\n");

        //hashcode
        System.out.println("integers.hashcode: " + integers.get(0).hashCode() + " (index = " + 0 + ")");
        System.out.println("integers.hashcode: " + integers.get(1).hashCode() + " (index = " + 1 + ")");

        //equals
        System.out.println("integers.equals: " + integers.get(0).equals(integers.get(1)) + "\n");

        //map
        System.out.println("integers.map: " + integers.map(Double::valueOf) + "\n");

        //Iterator
        int x = 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        System.out.println(list.indexOf(1));
        System.out.println();
        while (iterator.hasNext()) {
            System.out.println("integers.iterator: " + iterator.next() + " (index = " + integers.indexOf(iterator.next()) + ")");
            x++;
        }
        //2
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        List<Double> list2 = list.stream().map(Integer::doubleValue).toList();
//        System.out.println(list2);

    }
}
