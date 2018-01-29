package dataStructures;

import dataStructures.binaryTrees.BinarySearchTree;
import dataStructures.binaryTrees.BinaryTree.Node;

public class MainBST {

	public static void main(String[] args) {

		/*    2
	        /   \
	       7     5
	        \     \
	         6     9
	        / \   /
	       1  11 4
        */
		
		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insert(2);
		tree.insert(7);
		tree.insert(5);
		tree.insert(6);
		tree.insert(1);
		tree.insert(11);
		tree.insert(9);
		tree.insert(4);
		
//		tree.insert(2, 2);
//		tree.insert(7, 7);
//		tree.insert(5, 5);
//		tree.insert(6, 6);
//		tree.insert(1, 1);
//		tree.insert(11, 11);
//		tree.insert(9, 9);
//		tree.insert(4, 4);
		
		Node<Integer> root = tree.getRoot();
		
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
		System.out.println("\nNodes at 2 distance from root: ");
		tree.printNodesAtKDistanceFromRoot(root, 2);
		
		System.out.println("\nDelete 7: ");
		tree.deleteData(7);
		tree.inorder(root);
		
		System.out.println("\n\nBST vertical order:");
		tree.printVerticalOrder(root);
	}
}