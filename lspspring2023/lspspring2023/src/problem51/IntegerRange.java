package org.howard.edu.lsp.midterm.problem51;

public class IntegerRange implements Range {
	private int lower;
	private int upper;

// Hint: implement getters for lower and upper

	 IntegerRange(int lower, int upper) { 	// Constructor
    		this.lower = lower;
    		this.upper = upper;
	 }
	 public boolean contains(int value) {
		 return value >= lower && value <= upper;
	}
	 public boolean overlaps(Range other) throws EmptyRangeException {
		 if (other == null || other.size()>0) {
		        throw new EmptyRangeException("The other range is empty or null.");
		    }
		    for (int i = lower; i <= upper; i++) {
		        if (other.contains(i)) {
		            return true;
		        }
		    }
		    return false;
	}

	 public int size()  {
		 return upper - lower + 1;
	 }
}

