package org.howard.edu.lsp.assignment4;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    private List<Integer> set;

    // Default constructor
    public IntegerSet() {
        this.set = new ArrayList<>();
    }
    @Override
    public String toString() {
        return this.set.toString();
    }

    // Clears the internal representation of the set
    public void clear() {
        this.set.clear();
    }

    // Returns the length of the set
    public int length() {
        return this.set.size();
    }

    // Returns true if the 2 sets are equal, false otherwise
    public boolean equals(IntegerSet b) {
        if (this.set.size() != b.length()) {
            return false;
        }

        for (int i = 0; i < this.set.size(); i++) {
            if (!b.contains(this.set.get(i))) {
                return false;
            }
        }

        return true;
    }

    // Returns true if the set contains the value, otherwise false
    public boolean contains(int value) {
        return this.set.contains(value);
    }

    // Returns the largest item in the set; Throws a IntegerSetException if the set is empty
    public int largest() {
        int largest = this.set.get(0);
        for (int i = 1; i < this.set.size(); i++) {
            if (this.set.get(i) > largest) {
                largest = this.set.get(i);
            }
        }

        return largest;
    }

    // Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
    public int smallest() {
        int smallest = this.set.get(0);
        for (int i = 1; i < this.set.size(); i++) {
            if (this.set.get(i) < smallest) {
                smallest = this.set.get(i);
            }
        }

        return smallest;
    }

    // Adds an item to the set or does nothing it already there	
    public void add(int item) {
        if (!this.set.contains(item)) {
            this.set.add(item);
        }
    }

    // Removes an item from the set or does nothing if not there
    public void remove(int item) {
        this.set.remove(Integer.valueOf(item));
    }

    // Set union
    public void union(IntegerSet intSetb) {
        for (int i = 0; i < intSetb.length(); i++) {
            int item = intSetb.set.get(i);
            if (!this.set.contains(item)) {
                this.set.add(item);
            }
        }
    }

    // Set intersection
    public void intersect(IntegerSet intSetb) {
        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < this.set.size(); i++) {
            int item = this.set.get(i);
            if (intSetb.contains(item)) {
                intersection.add(item);
            }
        }
        this.set = intersection;
    }
}
