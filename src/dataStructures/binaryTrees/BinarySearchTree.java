package dataStructures.binaryTrees;


public class BinarySearchTree<T> extends BinaryTree<T> {

	public Node<Integer> search(Node<Integer> root, int data) {
		if (root == null || root.getData() == data)
			return root;
		
		if (root.getData() > data)
			return search(root.getLeft(), data);
		
		return search(root.getRight(), data);
	}
	
	public void insert(int key) {
		root = insertRec(root, key);
    }
	     
	private Node insertRec(Node root, int key) {
	 
        if (root == null) {
            root = new Node(key);
            return root;
        }
 
        if (key < (int) root.getData())
            root.setLeft(insertRec(root.getLeft(), key));
        else if (key > (int) root.getData())
            root.setRight(insertRec(root.getRight(), key));
 
        return root;
    }
	
	public void insert(T data, int key) {
		root = insert(root, new Node<T>(data, key));
	}
	
	private Node<T> insert(Node<T> root, Node<T> newNode) {
		if (root == null) 
			return newNode;
		else if (root.getKey() < newNode.getKey()) 
			root.setRight(insert(root.getRight(), newNode));
		else if (root.getKey() > newNode.getKey()) 
			root.setLeft(insert(root.getLeft(), newNode));

		return root;
	}
	
	public int minValue(Node<T> root) {
		int min = root.getKey();
		
		while (root.getLeft() != null) {
			min = root.getLeft().getKey();
			root = root.getLeft();
		}
		
		return min;
	}
	
	public int maxValue(Node<T> root) {
		int max = root.getKey();
		
		while (root.getRight() != null) {
			max = root.getRight().getKey();
			root = root.getRight();
		}
		
		return max;
	}
	
	public void deleteData(int data) {
		root = deleteRec(root, data);
	}
	
	public Node<T> deleteRec(Node<T> root, int key) {
		if (root == null)  
			return root;
		 
        if (key < root.getKey())
            root.setLeft(deleteRec(root.getLeft(), key)); 
        else if (key > root.getKey())
            root.setRight(deleteRec(root.getRight(), key));
 
        else {
            if (root.getLeft() == null)
                return root.getRight();
            else if (root.getRight() == null)
                return root.getLeft();
 
            root.setKey(minValue(root.getRight()));
            root.setRight(deleteRec(root.getRight(), root.getKey()));
        }
 
        return root;
	}
}