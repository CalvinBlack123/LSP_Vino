package org.howard.edu.lsp.assignment5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerSetTest {
    private IntegerSet set;

    @Before
    public void setUp() {
        set = new IntegerSet();
    }

    @Test
    public void testAdd() {
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(set.length(), 3);
    }

    @Test
    public void testContains() {
        set.add(1);
        assertTrue(set.contains(1));
        assertFalse(set.contains(2));
    }

    @Test
    public void testRemove() {
        set.add(1);
        set.remove(1);
        assertEquals(set.length(), 0);
    }

    @Test
    public void testUnion() {
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet otherSet = new IntegerSet();
        otherSet.add(3);
        otherSet.add(4);
        otherSet.add(5);

        set.union(otherSet);
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(3));
        assertTrue(set.contains(4));
        assertTrue(set.contains(5));
        assertEquals(set.length(), 5);
    }

    @Test
    public void testIntersection() {
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet otherSet = new IntegerSet();
        otherSet.add(3);
        otherSet.add(4);
        otherSet.add(5);

        set.intersect(otherSet);
        assertTrue(set.contains(3));
        assertEquals(set.length(), 1);
    }

    @Test
    public void testClear() {
        set.add(1);
        set.clear();
        assertEquals(set.length(), 0);
    }

    @Test
    public void testLargest() {
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(set.largest(), 3);
    }

    @Test
    public void testLargestEmptySet() {
    	try {
    		set.largest();
    	} catch(Exception e) {
    		System.out.println(e.toString());
    	}
    }

    @Test
    public void testSmallest() {
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(set.smallest(), 1);
    }

    @Test
    public void testSmallestEmptySet(){
    	try {
    		set.smallest();
    	} catch(Exception e) {
    		System.out.println(e.toString());
    	}
    }

    @Test
    public void testEquals() {
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet otherSet = new IntegerSet();
        otherSet.add(3);
        otherSet.add(2);
        otherSet.add(1);

        assertTrue(set.equals(otherSet));
    }

    @Test
    public void testNotEquals() {
        set.add(1);
        set.add(2);
        set.add(3);

        IntegerSet otherSet = new IntegerSet();
        otherSet.add(3);
        otherSet.add(4);
        otherSet.add(5);

        assertFalse(set.equals(otherSet));
    }
}
