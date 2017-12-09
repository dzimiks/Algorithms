package algorithms.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {

	protected Node<T> root;
	
	public void preorder(Node<T> root) {
		if (root != null) {
			System.out.print(root);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void preorderWithStack(Node<T> node) {
       if (node == null) 
           return;

       Stack<Node> nodeStack = new Stack<Node>();
       nodeStack.push(root);

       while (nodeStack.empty() == false) {
           Node<T> mynode = nodeStack.peek();
           System.out.print("[" + mynode.data + "]");
           nodeStack.pop();

           if (mynode.right != null) 
               nodeStack.push(mynode.right);
           if (mynode.left != null) 
               nodeStack.push(mynode.left);
       }
   }
	
	public void inorder(Node<T> root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root);
			inorder(root.right);
		}
	}
	
	public void inorderWithStack(Node<T> root) {
        if (root == null) 
            return;
        
        Stack<Node> stack = new Stack<Node>();
        Node<T> node = root;
         
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print("[" + node.data + "]");
            
            if (node.right != null) {
                node = node.right;
                 
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }
	
	public void inorderMorrisTraversal(Node<T> root) {
        Node<T> current, pre;
          
        if (root == null)
            return;
          
        current = root;
        
        while (current != null) {
            if (current.left == null) {
                System.out.print("[" + current.data + "]");
                current = current.right;
            }
            else {
                pre = current.left;
                while (pre.right != null && pre.right != current) 
                    pre = pre.right;
                 
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } 
                else {
                    pre.right = null;
                    System.out.print("[" + current.data + "]");
                    current = current.right;
                }   
            } 
        } 
    }
	
	public void postorder(Node<T> root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root);
		}
	}
	
	public void postorderWithTwoStacks(Node<T> root) {
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
 
        if (root == null)
            return;
 
        s1.push(root);
         
        while (!s1.isEmpty()) {
            Node<T> temp = s1.pop();
            s2.push(temp);
         
            if (temp.left != null)
                s1.push(temp.left);

            if (temp.right != null)
                s1.push(temp.right);
        }
 
        while (!s2.isEmpty()) {
            Node<T> temp = s2.pop();
            System.out.print("[" + temp.data + "]");
        }
    }
	
	public void levelOrder() {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		
		while (!queue.isEmpty()) {
			Node<T> tmp = queue.poll();
			System.out.print("[" + tmp.data + "]");
			
			if (tmp.left != null)
				queue.add(tmp.left);
			if (tmp.right != null)
				queue.add(tmp.right);
		}
	}
	
	public Node<Integer> lca(Node<Integer> root, int v1, int v2) {

		if (root == null)
			return null;
		
		if (root.data < v1 && root.data < v2)
	        return lca(root.right, v1, v2);

	    if (root.data > v1 && root.data > v2)
	        return lca(root.left, v1, v2);

	    return root;
	}
	
	public boolean checkBST(Node<Integer> root, int minValue, int maxValue) {
	    if (root == null) 
	        return true;
	    
	    if (root.data < minValue || root.data > maxValue) 
	        return false;
	    
	    return (checkBST(root.left, minValue, root.data - 1) &&  
	    		checkBST(root.right, root.data + 1, maxValue));
	}
	    
	public boolean checkBST(Node<Integer> root) {
	    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public void delete(Node<T> root) {
		if (root == null)
			return;
		
		delete(root.left);
		delete(root.right);
		root = null;
	}
	
	public int height(Node<T> root) {
        if (root == null)
            return 0;
        else {
            int lDepth = height(root.left);
            int rDepth = height(root.right);
  
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }
	
	public int size(Node<T> root) {
		if (root == null)
			return 0;
		else
			return size(root.left) + size(root.right) + 1;
	}
	
	public boolean identicalTrees(Node<T> a, Node<T> b) {
        if (a == null && b == null)
            return true;
             
        if (a != null && b != null) 
            return (a.data == b.data && 
            		identicalTrees(a.left, b.left) &&
                    identicalTrees(a.right, b.right));
  
        return false;
    }
	
	public boolean isLeaf(Node<T> node) {
        if (node == null)
            return false;
        
        if (node.left == null && node.right == null)
            return true;
        
        return false;
    }
	
	public int sumOfAllNodes(Node<Integer> root) {
		if (root == null)
			return 0;
		
		return root.data + sumOfAllNodes(root.left) + sumOfAllNodes(root.right);
	}
	
	public void setRoot(Node<T> root) {
		this.root = root;
	}

	public Node<T> getRoot() {
		return root;
	}

	public static class Node<T> {
		
		private T data;
		private int key;
		private Node<T> left;
		private Node<T> right;
		
		public Node(T data) {
			this.data = data;
			this.key = 0;
			this.left = null;
			this.right = null;
		}
		
		public Node(T data, int key) {
			this.data = data;
			this.key = key;
			this.left = null;
			this.right = null;
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public Node<T> getLeft() {
			return left;
		}

		public void setLeft(Node<T> left) {
			this.left = left;
		}

		public Node<T> getRight() {
			return right;
		}

		public void setRight(Node<T> right) {
			this.right = right;
		}
		
		@Override
		public String toString() {
			if (data == null)
				return "";
			
			return "[" + data + "]";
		}
	}
}