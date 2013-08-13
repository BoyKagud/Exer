package main;

public class Stack {
	
	private Node Head;
	private int size;

	public Stack() {
		Head = new Node(null);
		size = 0;
	}
	
	public void push(Object obj) {
		Node n = new Node(obj, Head.getNext());
		Head.setNext(n);
		size++;
	}
	
	public void pop() {
		if(Head != null && Head.getNext() != null){
			Node cur = Head.getNext();
			Node newNext = cur.getNext();
			Head.setNext(newNext);
		}
		size--;
	}
	
	public Object top() {
		if(Head != null && Head.getNext() != null){
			Node cur = Head.getNext();
			return cur.getItem();
		}
		return null;
	}
	
	public boolean isEmpty() {
		if(Head.getNext() == null) {
			return true;
		}
		return false;
	}
	
	public int getSize() {
		return size;
	}
	
	public void printStack() {
		if(Head.getNext() != null) {
			Node cur = Head.getNext();
			for(int k=0; k<size;  k++) {
				System.out.print(cur.getItem()+" ");
				cur = cur.getNext();
			}
		}
	}
	
}
