package dataStructures;

import dataStructures.search.hashing.DoubleHashing;

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