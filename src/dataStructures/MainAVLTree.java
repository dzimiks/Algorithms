package dataStructures;

import dataStructures.binaryTrees.AVL.AVLTree;

public class MainAVLTree {

	public static void main(String[] args) {

		AVLTree tree = new AVLTree();
		
		tree.setRoot(tree.insert(tree.getRoot(), 10));
		tree.setRoot(tree.insert(tree.getRoot(), 20));
		tree.setRoot(tree.insert(tree.getRoot(), 30));
		tree.setRoot(tree.insert(tree.getRoot(), 40));
		tree.setRoot(tree.insert(tree.getRoot(), 50));
		tree.setRoot(tree.insert(tree.getRoot(), 25));
	
		System.out.println("Preorder traversal of constructed tree is: ");
		tree.preorder(tree.getRoot());
		
		System.out.println("\n\nPreorder traversal after deletion of 10: ");
		tree.setRoot(tree.delete(tree.getRoot(), 10));
		tree.preorder(tree.getRoot());
	}
}