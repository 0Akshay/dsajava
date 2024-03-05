import java.util.Scanner;

public class BinarySearchTree  {
	public static void main(String[] args) {
		System.out.println("Binary Search Tree Implementation");
		
		BST tree = new BST();

		tree.insert(22);
		tree.insert(12);
		tree.insert(8);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.insert(25);

		tree.printBST();

	}
}


class BST {
	class Node {
		int data;
		Node left;
		Node right;
		
		Node() {
			data = 0;
			left = null;
			right = null;
		}
	}
	
	Node root = null;

	void insert (int item) {
		Node newNode = new Node();
		newNode.data = item;

		if (root == null) {
			root = newNode;
		}
		else {
			Node q = root;
			
			while (true) {
				int currentData = q.data;
				if(item < currentData) {
					if (q.left == null) {
						q.left = newNode;
						return;
					}
					else {
						q = q.left;
					}
				}
				else if (item >= currentData) {
					if (q.right == null) {
						q.right = newNode;
						return;
					}
					else {
						q = q.right;
					}
				}
			}
		}
	}
	
	void printBST() {
		System.out.println("\nTree");
		printBSTHelper(root);
	}

	private void printBSTHelper(Node node) {
		if (node != null) {
			System.out.println(node.data);
			printBSTHelper(node.left);
			printBSTHelper(node.right);
		}
	}
}