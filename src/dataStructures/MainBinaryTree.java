package dataStructures;

import dataStructures.binaryTree.BinaryTree;
import dataStructures.binaryTree.BinaryTree.Node;

public class MainBinaryTree {

	public static void main(String[] args) {

		BinaryTree<Integer> tree = new BinaryTree<>();
		
		tree.setRoot(new Node<Integer>(4));
		tree.getRoot().setLeft(new Node<Integer>(2));
		tree.getRoot().setRight(new Node<Integer>(7));
		tree.getRoot().getLeft().setLeft(new Node<Integer>(1));
		tree.getRoot().getLeft().setRight(new Node<Integer>(3));
		tree.getRoot().getRight().setLeft(new Node<Integer>(6));
		
		System.out.println("Preorder:");
		tree.preorder(tree.getRoot());
		
//		System.out.println("\n\nPreorder with stack:");
//		tree.preorderWithStack(tree.getRoot());
		
		System.out.println("\n\nInorder:");
		tree.inorder(tree.getRoot());
		
//		System.out.println("\n\nInorder with stack:");
//		tree.inorderWithStack(tree.getRoot());
//		
//		System.out.println("\n\nInorder Morris traversal:");
//		tree.inorderMorrisTraversal(tree.getRoot());
		
		System.out.println("\n\nPostorder:");
		tree.postorder(tree.getRoot());
		
//		System.out.println("\n\nPostorder with two stacks:");
//		tree.postorderWithTwoStacks(tree.getRoot());
		
		System.out.println("\n\nLevel order:");
		tree.levelOrder();
		
		System.out.println("\n\nLCA:");
		System.out.println(tree.lca(tree.getRoot(), 1, 7));
		
		System.out.println("\nCheck is it BST: ");
		System.out.println(tree.checkBST(tree.getRoot()) ? "It is BST" : "It is not BST");
		
//		System.out.println("\nDelete tree:");
//		tree.delete(tree.getRoot());
//		tree.setRoot(null);
//		System.out.println(tree.getRoot());
		
		System.out.println("\nHeight of tree is: " + tree.height(tree.getRoot()));
		
		System.out.println("\nSize of tree is: " + tree.size(tree.getRoot()));
		
		System.out.print("\nIs leaf node: ");
		System.out.println(tree.isLeaf(tree.getRoot().getRight().getLeft()) ? "yes" : "no");
		
		System.out.println("\nSum of all nodes is: " + tree.sumOfAllNodes(tree.getRoot()));
	}
}