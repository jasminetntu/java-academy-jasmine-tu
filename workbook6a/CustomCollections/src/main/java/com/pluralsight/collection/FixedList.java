package com.pluralsight.collection;

import java.util.ArrayList;
import java.util.List;

public class FixedList<T> {
    private final List<T> items;
    private int maxSize;

    public FixedList(int maxSize) {
        items = new ArrayList<>();
        this.maxSize = maxSize;
    }

    // *** GETTERS ***

    public List<T> getItems() {
        return items;
    }

    public int getMaxSize() {
        return maxSize;
    }

    // *** SETTERS ***

    public void add(T item) {
        if (items.size() >= maxSize) {
            System.out.println("Cannot add " + item + ". Max size reached.");
        }
        else {
            items.add(item);
        }
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
