package org.example;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] items;
    private int size;

    public StringListImpl() {
        this.items = new String[10];
        this.size = 0;
    }

    @Override

    public String add(String item) {
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        items[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Такого индекса массива не существует " + index);
        }
        if (size == items.length) {
            items = Arrays.copyOf(items, items.length * 2);
        }
        System.arraycopy(items, index, items, index + 1, size - index);
        items[index] = item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Такого индекса массива не существует " + index);
        }
        items[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals(item)) {

            }

        }

        return null;
    }

    @Override
    public String remove(int index) {
        return null;
    }

    @Override
    public boolean contains(String item) {
        return false;
    }

    @Override
    public int indexOf(String item) {
        return 0;
    }

    @Override
    public int lastIndexOf(String item) {
        return 0;
    }

    @Override
    public String get(int index) {
        return null;
    }

    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public String[] toArray() {
        return new String[0];
    }

    public String[] getItems() {
        return Arrays.copyOf(items, size);
    }

    public int getSize() {
        return size;
    }
}
