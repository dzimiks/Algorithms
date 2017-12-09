package dataStructures;

import dataStructures.binaryTree.BinarySearchTree;

public class MainBST {

	public static void main(String[] args) {

		BinarySearchTree<Integer> tree = new BinarySearchTree<>();
		
		tree.insert(10, 10);
		tree.insert(20, 20);
		tree.insert(30, 30);
		tree.insert(40, 40);
		tree.insert(25, 25);
		tree.insert(7, 7);
		
		System.out.println("Preorder: ");
		tree.preorder(tree.getRoot());
		System.out.println("\n\nInorder: ");
		tree.inorder(tree.getRoot());
		System.out.println("\n\nPostorder: ");
		tree.postorder(tree.getRoot());
		
		System.out.println("\n\nSearch for 2: " + tree.search(tree.getRoot(), 2));
		
		System.out.println("\nMin value in BST: " + tree.minValue(tree.getRoot()));
		
		System.out.println("\nMax value in BST: " + tree.maxValue(tree.getRoot()));
		
		System.out.println("\nDelete 7: ");
		tree.deleteData(7);
		tree.inorder(tree.getRoot());
	}
}