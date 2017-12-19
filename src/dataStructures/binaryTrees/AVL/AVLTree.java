package dataStructures.binaryTrees.AVL;


public class AVLTree {

	Node root;
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int height(Node root) {
		if (root == null)
			return 0;
		
		return root.height;
	}
	
	private int max(int a, int b) {
		return a > b ? a : b;
	}
	
	private Node rightRotate(Node y) {
		
		Node x = y.left;
		Node T2 = x.right;
		
		x.right = y;
		y.left = T2;
		
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		
		return x;
	}
	
	private Node leftRotate(Node x) {
		
		Node y = x.right;
		Node T2 = y.left;
		
		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		
		return y;
	}
	
	public int getBalance(Node root) {
		if (root == null)
			return 0;
		
		return height(root.left) - height(root.right);
	}
	
	// Time Complexity: O(logn)
	public Node insert(Node node, int key) {
		
		if (node == null)
			return new Node(key);
		
		if (key < node.key)
			node.left = insert(node.left, key);
		else if (key > node.key)
			node.right = insert(node.right, key);
		else
			return node;
		
		node.height = max(height(node.left), height(node.right)) + 1;
		int balance = getBalance(node);
		
		if (balance > 1 && key < node.left.key)
			return rightRotate(node);
		
		if (balance < -1 && key > node.right.key)
            return leftRotate(node);
 
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
 
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
		
		return node;
	}
	
	public Node minValueNode(Node node) {
		
        Node current = node;
 
        while (current.left != null)
           current = current.left;
 
        return current;
    }
 
	// Time Complexity: O(logn)
    public Node delete(Node root, int key) {

    	if (root == null)
            return root;
 
        if (key < root.key)
            root.left = delete(root.left, key);
 
        else if (key > root.key)
            root.right = delete(root.right, key);
 
        else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
                if (temp == null) {
                    temp = root;
                    root = null;
                }
                else   
                    root = temp; 
            }
            else {
                Node temp = minValueNode(root.right);
                root.key = temp.key;
                root.right = delete(root.right, temp.key);
            }
        }
 
        if (root == null)
            return root;
 
        root.height = max(height(root.left), height(root.right)) + 1;
        int balance = getBalance(root);
 
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
 
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
 
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
 
        return root;
    }
	
	public void preorder(Node root) {
		if (root != null) {
			System.out.print("[" + root.key + "]");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	private static class Node {
		
		private int key;
		private int height;
		private Node left;
		private Node right;
		
		public Node(int key) {
			this.key = key;
			height = 1;
		}
		
		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}
}