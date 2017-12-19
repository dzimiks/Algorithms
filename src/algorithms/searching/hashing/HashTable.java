package algorithms.searching.hashing;

public interface HashTable {

	public boolean add(Object element);
	public Object search(int key);
	public Object delete(int key);
	public int numOfElements();
}