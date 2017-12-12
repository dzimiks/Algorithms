package dataStructures;

import java.util.Arrays;
import java.util.HashSet;

import dataStructures.searching.hashing.DoubleHashing;

public class MainHashing {

	public static void main(String[] args) {

		DoubleHashing hashTable = new DoubleHashing(10);
		Person p1 = new Person(1, "Vanja");
		Person p2 = new Person(1, "Olja");
		Person p3 = new Person(3, "Mihailo");
		Person p4 = new Person(4, "Milos");
		Person p5 = new Person(5, "Aleksa");
		Person p13 = new Person(13, "Branko");
		
		hashTable.add(p3);
		hashTable.add(p5);
		hashTable.add(p1);
		hashTable.add(p2);
		hashTable.add(p4);
		hashTable.add(p13);
		
		System.out.println(hashTable.search(1));
		System.out.println(hashTable.search(4));
		System.out.println(hashTable.search(3));
		
		hashTable.delete(1);
		
		System.out.println(hashTable.search(1));
		System.out.println();
		
		// Find whether an array is subset of another array
		int[] arr1 = {11, 1, 13, 21, 3, 7};
        int[] arr2 = {11, 3, 7, 1};
         
        int m = arr1.length;
        int n = arr2.length;
             
        if (isSubset(arr1, arr2, m, n))
        	System.out.println("Arr2 is a subset of Arr1.");
        else
        	System.out.println("Arr2 is not a subset of Arr1.");
        
        // Find the first repeating element in an array of integers
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println();
        printFirstRepeating(arr);
	}
	
	// Time Complexity: O(n)
	public static boolean isSubset(int[] arr1, int[] arr2, int m, int n) {

		HashSet<Integer> hset = new HashSet<>();
		
		for (int i = 0; i < m; i++)
			if (!hset.contains(arr1[i]))
				hset.add(arr1[i]);
		
		for (int i = 0; i < n; i++)
			if (!hset.contains(arr2[i]))
				return false;
		
		return true;
	}
	
	// Time Complexity: O(n)
	public static void printFirstRepeating(int[] arr) {
		
		int min = -1;
		HashSet<Integer> hset = new HashSet<>();
		
		for (int i = arr.length - 1; i >= 0; i--) {
			if (hset.contains(arr[i]))
				min = i;
			else
				hset.add(arr[i]);
		}
		
		if (min != -1)
            System.out.println("The first repeating element in array " + Arrays.toString(arr) + " is " + arr[min]);
        else
        	System.out.println("There are no repeating elements");
	}
	
	private static class Person {
		
		public int id;
		public String name;
		
		public Person(int id, String name) {
			this.id = id;
			this.name = name;
		}

		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "[" + id + " - " + name + "]";
		}
		
		@Override
		public int hashCode() {
			return id;
		}
	}
}