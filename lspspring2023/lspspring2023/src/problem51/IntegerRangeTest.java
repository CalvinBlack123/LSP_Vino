package org.howard.edu.lsp.midterm.problem51;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class IntegerRangeTest {

    private IntegerRange range;

    @Before
    public void setUp() {
        range = new IntegerRange(0, 10);
    }

    @Test
    public void testContains() {
        assertTrue(range.contains(0));
        assertTrue(range.contains(5));
        assertTrue(range.contains(10));
        assertFalse(range.contains(-1));
        assertFalse(range.contains(11));
    }

    @Test
    public void testOverlaps() throws EmptyRangeException {
        IntegerRange other1 = new IntegerRange(-5, 5);
        IntegerRange other2 = new IntegerRange(11, 20);
        IntegerRange other3 = new IntegerRange(5, 15);
        try {
        	assertTrue(range.overlaps(other1));
        	assertFalse(range.overlaps(other2));
        	assertTrue(range.overlaps(other3));
           	range.overlaps(null);
            fail("Expected EmptyRangeException");
        } catch (EmptyRangeException e) {
            // expected exception
        }
    }

    @Test
    public void testSize() {
        assertEquals(11, range.size());
        IntegerRange smallerRange = new IntegerRange(5, 8);
        assertEquals(4, smallerRange.size());
    }

}

