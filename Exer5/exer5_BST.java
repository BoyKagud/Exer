package main;

import java.util.Formatter;
import java.util.Scanner;

public class exer5_BST {
	
	class BinNode {
		String key;
		BinNode leftChild; 
		BinNode rightChild;
		
		public BinNode() {
			leftChild = null;
			rightChild = null;
		}
	}
	
	private static BinNode root;
	private BinNode inputChron[]={};
	
	public static void main(String[] arg0) {
		new exer5_BST();
	}
	
	public exer5_BST() {
		root =  null;
		getInput();
	}
	
	public void insert(String k) {
		BinNode newNode = new BinNode(); 
		newNode.key = k; 
		insertToInputArray(newNode);
		if(root==null) 
			root = newNode;
		else {
			BinNode current = root; 
			BinNode parent;
			while(true) {
				parent = current;
					if(eval(newNode, current) == 1) {
						// right
						current = current.rightChild;
						if(current == null) { 
							parent.rightChild = newNode;
							return;
						}
					} else {
						current = current.leftChild;
						if(current == null) { 
							parent.leftChild = newNode;
							return;
						}
					}
			} 
		}
	} 
	
	public int eval(BinNode newNode, BinNode cur) {
		int loop=0;
		if(newNode.key.length()>cur.key.length()) loop= cur.key.length();
		else loop=newNode.key.length();
		int dir = 0;
		for(int now=0; now<loop; now++) {
			if(getIntVal(newNode.key.charAt(now)) < getIntVal(cur.key.charAt(now))) return 0;
			else if(getIntVal(newNode.key.charAt(now)) > getIntVal(cur.key.charAt(now))) return 1;
		}
		return -1;
	}
	
	public int getIntVal(char item) {
		char[] alpha = { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z' };
		int alphaNum = alpha.length-1;
		for(int k=0; k <= alphaNum; k++) {
			if(alpha[k] == item) return k;
		}
		return -1;
	}

	public void display() {
		Formatter layout = new Formatter();
		for(int k = inputChron.length-1; k>=0; k--) {
			if(k == inputChron.length-1) layout.format("%-15s %s \n", inputChron[k].key, "Root");
			else layout.format("%-15s %s \n", inputChron[k].key, getChildPos(root, inputChron[k]));
		}
		System.out.println(layout);
	}
	
	public String getChildPos(BinNode localRoot, BinNode child) {
		
		BinNode cur = localRoot;
		while(true) {
			if(cur != null) {				
				if(cur.leftChild != null && cur.leftChild.key.equals(child.key)) 
					return "Left child of \""+cur.key+"\"";
				else if(cur.rightChild != null && cur.rightChild.key.equals(child.key)) 
					return "Right child of \""+cur.key+"\"";
				if( getIntVal(cur.key.charAt(0)) > getIntVal(child.key.charAt(0)) ) cur = cur.leftChild;
				else if( getIntVal(cur.key.charAt(0)) < getIntVal(child.key.charAt(0)) ) cur = cur.rightChild;
			} else return null;
		}
		
	}
		
	public void getInput() {
		Scanner in = new Scanner(System.in);
		
		// root
		System.out.print("Enter root string: ");
		BinNode r = new BinNode();
		r.key = in.next().toLowerCase();
		root = r;
		insertToInputArray(root);
		
		// items
		String key = "";
		while(!key.equals(".")) {
			System.out.print("\nInsert string or period(.) to stop: ");
			key = in.next().toLowerCase();
			if(!key.equals(".")) insert(key);
		}
		display();
	}
	
	public void insertToInputArray(BinNode node) {
		int last = inputChron.length;

        int arrLength = last;
        BinNode[] newArray = new BinNode[arrLength+1];
        newArray[0] = node;
        int itr = 1;
        for(BinNode k: inputChron) {
            newArray[itr] = k;
            itr++;
        }
        inputChron = newArray;
	}

}