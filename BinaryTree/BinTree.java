package exer4;

public class BinTree {
	
	class BinNode {
		int key;
		BinNode leftChild; 
		BinNode rightChild;
		
		public BinNode() {
			leftChild = null;
			rightChild = null;
		}
	}
	
	private BinNode root;
	int sum;
	
	public BinTree() {
		root =  null;
	}
	
	public boolean contains(int k) {
		BinNode current = root; 
		while(current.key != k) {
			if(k < current.key) 
				current = current.leftChild;
			else 
				current = current.rightChild;
			if(current == null) 
				return false; 
		}
		return true; 
	} 
	
	public void insert(int k) {
		BinNode newNode = new BinNode(); 
		newNode.key = k; 
		if(root==null) 
			root = newNode;
		else {
			BinNode current = root; 
			BinNode parent;
			while(true) {
				parent = current;
				if(k < current.key) {
					current = current.leftChild;
					if(current == null) { 
						parent.leftChild = newNode;
						return;
					}
				} 
				else {
					current = current.rightChild;
					if(current == null) { 
						parent.rightChild = newNode;
						return;
					}
				} 
			} 
		}
	} 

	public void preOrder(BinNode localRoot) {
		if(localRoot != null) {
			System.out.print(localRoot.key + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	
	public void displayPreorder() {
		preOrder(root);
		System.out.println();
	}
	
	public int getSum() {
		BinNode localroot = root;
		sum = 0;
		preOrderGetItem(root);
		return sum;
	}
	
	public void preOrderGetItem(BinNode localRoot) {
		if(localRoot != null) {
			sum = sum+localRoot.key;
			preOrderGetItem(localRoot.leftChild);
			preOrderGetItem(localRoot.rightChild);
		}
	}

}