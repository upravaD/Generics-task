package org.example;

import java.util.function.Function;
import java.util.*;

/**
 * Реализация параметризированного списка MyList
 */

public class MyList<N extends Number> implements Iterable<N> {

    private static final int DEFAULT_CAPACITY = 10;
    private N[] array;
    private int size = 0;

    public MyList() {
        this.array = (N[]) new Number[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        this.array = (N[]) new Number[size];
    }

    public void add(N number) {
        if (size >= DEFAULT_CAPACITY) {
            resize();
        }
        size++;
        array[size - 1] = number;
    }

    public N get(int index) {
        return array[index];
    }

    private void resize() {
        this.array = Arrays.copyOf(this.array, (int) (array.length * 1.5));
    }

    public N remove(int index) {
        N element = null;
        for (int i = index; i < size - 1; i++) {
            if (i == index) {
                element = array[i];
            }
            array[i] = array[i + 1];
        }
        size--;
        return element;
    }

    public <M extends Number> MyList<M> map(Function<? super N, ? extends M> mapper) {
        MyList<M> mappedList = new MyList<>();
        for (N n : array) {
            if (n != null) {
                mappedList.add(mapper.apply(n));
            }
        }
        return mappedList;
    }

    public int size() {
        return size;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public MyIterator iterator() {
        return new MyIterator();
    }

    /**
     *      Описать разницу между статическим InnerClass и обычным
     */
    public class MyIterator implements Iterator<N> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public N next() {
            return null;
        }
    }
}
