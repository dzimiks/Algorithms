package dataStructures;

import dataStructures.binaryTrees.BinarySearchTree;
import dataStructures.binaryTrees.BinaryTree.Node;

public class MainBST {

	public static void main(String[] args) {

		/*
		 		6
		 	  /   \
		 	 2      8
		    / \    / \
		   1   5  7   11
		      /      /
		     4      9
		 */
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();

		tree.insert(6, 6);
		tree.insert(8, 8);
		tree.insert(2, 2);
		tree.insert(5, 5);
		tree.insert(1, 1);
		tree.insert(7, 7);
		tree.insert(11, 11);
		tree.insert(9, 9);
		tree.insert(4, 4);
		
		BinarySearchTree<Integer> subtree = new BinarySearchTree<>();
		
		subtree.insert(8, 8);
		subtree.insert(7, 7);
		subtree.insert(11, 11);
		subtree.insert(9, 9);
		
		Node<Integer> root = tree.getRoot();
		Node<Integer> subtreeRoot = subtree.getRoot();
		
		System.out.println("Preorder: ");
		tree.preorder(root);
		System.out.println("\n\nInorder: ");
		tree.inorder(root);
		System.out.println("\n\nPostorder: ");
		tree.postorder(root);
		
		System.out.println("\n\nSearch for 2: " + tree.search(root, 2));
		System.out.println("Min value in BST: " + tree.minValue(root));
		System.out.println("Max value in BST: " + tree.maxValue(root));
		System.out.println("Half nodes count: " + tree.getHalfNodesCount(root));
		System.out.println("Full nodes count: " + tree.getFullNodesCount(root));
		System.out.print("Avarage of levels in BST: ");
		tree.averageOfLevels(root);
		System.out.print("\nNodes at 2 distance from root: ");
		tree.printNodesAtKDistanceFromRoot(root, 2);
		System.out.print("\nNodes that don't have sibling: ");
		tree.printNodesWithoutSibling(root);
		System.out.println("\nDistance from root of 9 is " + tree.distanceFromRoot(root, 9));
		System.out.println("Are identical trees: " + tree.identicalTrees(root, subtreeRoot));
		System.out.println("Is B subtree of A: " + tree.isSubtree(root, subtreeRoot));
		System.out.println("Is full tree: " + tree.isFullTree(root));
		System.out.println("Is complete tree: " + tree.isCompleteTree(root, 0, tree.size(root)));
		System.out.println("Level of node 4 is: " + tree.getLevelOfNode(root, 4));
		System.out.println("The depth of the deepest odd level node is: " + tree.depthOfDeepestOddLevelLeafNode(root));
		System.out.println("Max width of tree is: " + tree.maxWidth(root));
		System.out.println("Longest consecutive sequence in BST is " + tree.longestConsecutiveSequence(root));
		
		for (int i = 1; i <= 9; i++) {
			tree.kthLargestNode(i);
		}
		
		System.out.println("\nBST vertical order:");
		tree.printVerticalOrder(root);
		
		System.out.println("\nDelete 7: ");
		tree.deleteData(7);
		tree.inorder(root);
	}
}