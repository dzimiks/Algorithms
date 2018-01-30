package dataStructures.binaryTrees;

import java.util.LinkedList;
import java.util.Map.Entry;

import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Vector;

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
	
	public boolean isSubtree(Node<T> a, Node<T> b) {
		if (b == null)
			return true;
		
		if (a == null)
			return false;
		
		if (identicalTrees(a, b))
			return true;
		
		return isSubtree(a.left, b) || isSubtree(a.right, b);
	}
	
	public boolean isFullTree(Node<T> root) {
		if (root == null)
			return true;
		
		if (root.left == null && root.right == null)
			return true;
		
		if (root.left != null && root.right != null)
			return isFullTree(root.left) && isFullTree(root.right);
		
		return false;
	}
	
	public boolean isCompleteTree(Node<T> root, int index, int numOfNodes) {
		if (root == null)
			return true;
		
		if (index >= numOfNodes)
			return false;
		
		return isCompleteTree(root.left, 2 * index + 1, numOfNodes) &&
			   isCompleteTree(root.right, 2 * index + 2, numOfNodes);
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
	
	public int getLevelOfNode(Node<Integer> root, int data) {
		return getLevelUtil(root, data, 1);
	}
	
	private int getLevelUtil(Node<Integer> root, int data, int level) {
		if (root == null)
			return 0;
		
		if (root.data == data)
			return level;
		
		int downLevel = getLevelUtil(root.left, data, level + 1);
		
		if (downLevel != 0)
			return downLevel;
		
		downLevel = getLevelUtil(root.right, data, level + 1);
		return downLevel;
	}
	
	public int depthOfDeepestOddLevelLeafNode(Node<Integer> root) {
		return depthOfOddLeafUtil(root, 1);
	}
	
	private int depthOfOddLeafUtil(Node<Integer> root, int level) {
		if (root == null)
			return 0;
		
		if (root.left == null && root.right == null && (level & 1) != 0)
			return level;
		
		return Math.max(depthOfOddLeafUtil(root.left, level + 1),
				        	  depthOfOddLeafUtil(root.right, level + 1));
	}
	
	public int numberOfNodesBetweenGivenRange(Node<Integer> root, int low, int high) {
		
		if (root == null)
			return 0;
		
		if (root.data >= low && root.data <= high) 
			return numberOfNodesBetweenGivenRange(root.left, low, high) + 
				   numberOfNodesBetweenGivenRange(root.right, low, high) + 1;
		else if (root.data < low)
			return numberOfNodesBetweenGivenRange(root.right, low, high);
		else
			return numberOfNodesBetweenGivenRange(root.left, low, high);
	}
	
	public void getVerticalOrder(Node<Integer> root, int horizontalDistance, 
			   					 TreeMap<Integer, Vector<Integer>> m) {
		
		if (root == null)
			return;
		
		Vector<Integer> get = m.get(horizontalDistance);
		
		if (get == null) {
			get = new Vector<>();
			get.add(root.data);
		}
		else 
			get.add(root.data);
		
		m.put(horizontalDistance, get);
		getVerticalOrder(root.left, horizontalDistance - 1, m);
		getVerticalOrder(root.right, horizontalDistance + 1, m);
	}
	
	public int maxWidth(Node<Integer> root) {
		
		if (root == null)
			return 0;
		
		int width = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int cnt = q.size();
			width = Math.max(cnt, width);
			
			while (cnt-- > 0) {
				Node<Integer> tmp = q.poll();
				
				if (tmp.left != null)
					q.add(tmp.left);
				
				if (tmp.right != null)
					q.add(tmp.right);
			}
		}
		
		return width;
	}
	
	public int longestConsecutiveSequence(Node<Integer> root) {
		if (root == null)
			return 0;
		
		int res = 0;
		longestConsecutiveSequenceUtil(root, 0, root.data, res);

		return res;
	}
	
	private void longestConsecutiveSequenceUtil(Node<Integer> root, int currLength, int expected, int res) {
		if (root == null)
			return;
		
		if (root.data == expected)
			currLength++;
		else
			currLength = 1;
		
		res = Math.max(res, currLength);
		longestConsecutiveSequenceUtil(root.left, currLength, root.data + 1, res);
		longestConsecutiveSequenceUtil(root.right, currLength, root.data + 1, res);
	}
	
	public void printVerticalOrder(Node<Integer> root) {
		
		TreeMap<Integer, Vector<Integer>> m = new TreeMap<>();
		int horizontalDistance = 0;
		getVerticalOrder(root, horizontalDistance, m);
		
		for (Entry<Integer, Vector<Integer>> entry : m.entrySet())
			System.out.println(entry.getValue());
	}

	public int getHalfNodesCount(Node<Integer> root) {

		int cnt = 0;
		
		if (root == null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			Node<Integer> tmp = q.poll();
			
			if (tmp.left != null && tmp.right == null ||
				tmp.left == null && tmp.right != null)
				cnt++;
			
			if (tmp.left != null)
				q.add(tmp.left);
			
			if (tmp.right != null)
				q.add(tmp.right);
		}
		
		return cnt;
	}
	
	public int getFullNodesCount(Node<Integer> root) {

		int cnt = 0;
		
		if (root == null)
			return 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			Node<Integer> tmp = q.poll();
			
			if (tmp.left != null && tmp.right != null)
				cnt++;
			
			if (tmp.left != null)
				q.add(tmp.left);
			
			if (tmp.right != null)
				q.add(tmp.right);
		}
		
		return cnt;
	}
	
	public void averageOfLevels(Node<Integer> root) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while (!q.isEmpty()) {
			int sum = 0;
			int cnt = 0;
			Queue<Node> tmp = new LinkedList<>();
			
			while (!q.isEmpty()) {
				Node<Integer> node = q.poll();
				
				sum += node.data;
				cnt++;
				
				if (node.left != null)
					tmp.add(node.left);
				
				if (node.right != null)
					tmp.add(node.right);
			}
			
			q = tmp;
			System.out.printf("%.2f ", sum * 1.0 / cnt);
		}
	}
	
	public void printNodesAtKDistanceFromRoot(Node<Integer> root, int k) {
		
		if (root == null)
			return;
		
		if (k == 0) {
			System.out.print("[" + root.data + "]");
			return;
		}
		else {
			printNodesAtKDistanceFromRoot(root.left, k - 1);
			printNodesAtKDistanceFromRoot(root.right, k - 1);
		}
	}
	
	public void printNodesWithoutSibling(Node<Integer> root) {
		
		if (root == null)
			return;
		
		if (root.left != null && root.right != null) {
			printNodesWithoutSibling(root.left);
			printNodesWithoutSibling(root.right);
		}
		else if (root.right != null) {
			System.out.print("[" + root.right.data + "]");
			printNodesWithoutSibling(root.right);
		}
		else if (root.left != null) {
			System.out.print("[" + root.left.data + "]");
			printNodesWithoutSibling(root.left);
		}
	}
	
	public int distanceFromRoot(Node<Integer> root, int x) {
		
		if (root == null)
			return -1;
		
		int dist = -1;
		
		if ((root.data == x) || 
			(dist = distanceFromRoot(root.left, x)) >= 0 || 
			(dist = distanceFromRoot(root.right, x)) >= 0)
			return dist + 1;
		
		return dist;
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
			this.key = (int) data;
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