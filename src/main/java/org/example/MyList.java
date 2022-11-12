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

    public int indexOf(N number) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], number)) {
                return i;
            }
        }
        return -1;
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
        int result = 1;
        for (N n : array) {
            result = 31 * result + n.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        MyList<? extends Number> result = (MyList<? extends Number>) obj;
        return Arrays.equals(array, result.array);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (i == 0) stringBuilder.append("[");
            if (i < size - 1) {
                stringBuilder
                        .append(array[i])
                        .append(", ");
            }
            if (i == size - 1) {
                stringBuilder
                        .append(array[i])
                        .append("]");
            }
        }
        return String.valueOf(stringBuilder);
    }

    public MyIterator iterator() {
        return new MyIterator();
    }

    /**
     * Описать разницу между статическим InnerClass и обычным InnerClass
     * 1. Из статического InnerClass`a можно обращаться только к статическим переменным.
     * 2. Экземпляр статического InnerClass`a нельзя создать без обьекта внешнего класса.
     */
    public class MyIterator implements Iterator<N> {
        int position = 0;

        @Override
        public boolean hasNext() {
            return position < size;
        }

        @Override
        public N next() {
            return array[position++];
        }
    }
}
