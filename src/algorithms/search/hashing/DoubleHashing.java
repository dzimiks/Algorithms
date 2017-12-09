package algorithms.search.hashing;

public class DoubleHashing implements HashTable {

	private static int SIZE = 100;
	
	private Object[] table;
	private int numOfElements;
	
	public DoubleHashing() {
		table = new Object[SIZE];
	}
	
	public DoubleHashing(int size) {
		if (size > 0)
			table = new Object[size];
		else
			table = new Object[SIZE];
		
		numOfElements = 0;
	}
	
	private int h(int x) {
		return x % table.length;
	}
	
	private int hh(int x) {
		return 1 + (x % (table.length - 1));
	}
	
	@Override
	public boolean add(Object element) {
		if (element == null)
			return false;
		
		int key = element.hashCode();
		int m = table.length;
		int hx = h(key);
		
		for (int i = 0; i < m; i++) {
			int pos = (hx + (i * hh(key))) % m;
			
			if (table[pos] == null) {
				table[pos] = element;
				numOfElements++;
				return true;
			}
			else if (table[pos].hashCode() == key) {
				table[pos] = element;
				return true;
			}
		}
		
		return false;
	}

	@Override
	public Object search(int key) {
		int m = table.length;
		int hx = h(key);
		
		for (int i = 0; i < m; i++) {
			int pos = (hx + (i * hh(key))) % m;
			
			if (table[pos] != null && table[pos].hashCode() == key)
				return table[pos];
		}
		
		return null;
	}

	@Override
	public Object delete(int key) {
		int m = table.length;
		int hx = h(key);
		Object found = null;
		int prev = -1;
		
		for (int i = 0; i < m; i++) {
			int pos = (hx + (i * hh(key))) % m;
			
			if (found == null) {
				if (table[pos] != null && table[pos].hashCode() == key) {
					found = table[pos];
					prev = pos;
					numOfElements--;
				}
			}
			else {
				table[prev] = table[pos];
				
				if (table[pos] == null)
					return found;
			}
			
			if (i == m && found != null)
				table[pos] = null;
		}
		
		return found;
	}
	
	@Override
	public int numOfElements() {
		return numOfElements;
	}

}