package org.howard.edu.lsp.assignment4;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerSet setA = new IntegerSet();
		IntegerSet setB = new IntegerSet();

		// add some items to setA
		setA.add(3);
		setA.add(1);
		setA.add(4);
		setA.add(2);

		// add some items to setB
		setB.add(4);
		setB.add(5);
		setB.add(6);

		// test length method
		assert setA.length() == 4;

		// test clear method
		setA.clear();
		assert setA.length() == 0;

		// test add method
		setA.add(1);
		setA.add(2);
		setA.add(3);
		setA.add(4);
		setA.add(1);
		setA.add(2);
		assert setA.length() == 4;

		// test remove method
		setA.remove(1);
		setA.remove(5);
		assert setA.length() == 3;
		assert setA.contains(2);
		assert setA.contains(3);
		assert setA.contains(4);
		assert !setA.contains(1);

		// test union method
		setA.union(setB);
		assert setA.length() == 6;
		assert setA.contains(1);
		assert setA.contains(2);
		assert setA.contains(3);
		assert setA.contains(4);
		assert setA.contains(5);
		assert setA.contains(6);

		// test intersection method
		setA.intersect(setB);
		assert setA.length() == 2;
		assert setA.contains(4);
		assert setA.contains(5);

		// test equals method
		IntegerSet setC = new IntegerSet();
		setC.add(4);
		setC.add(5);
		assert setA.equals(setC);

		// test largest method
		assert setA.largest() == 5;

		// test smallest method
		assert setA.smallest() == 4;
		
		System.out.println("Value of Set is:" + setA.toString());
		System.out.println("Smallest value in Set1 is:" + setA.smallest());
		System.out.println("Largest value in Set1 is:" + setA.largest());
		
		System.out.println("Union of Set1 and Set2");
		System.out.println("Value of Set1 is:" + setB.toString());
		System.out.println("Value of Set2 is:" + setB.toString());
		setA.union(setB);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2");
		setA.toString();	// result of union of set1 and set2


	}

}
