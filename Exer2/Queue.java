package main;

public class Queue {
	
	private Node Head;
	private int size;
	
	public Queue() {
		Head = new Node(null);
		size = 0;
	}
	
	public void enqueue(Object obj) {
		Node cur = Head;
		for(int k=0; k<size; k++) {
			cur = cur.getNext();
		}
		Node in = new Node(obj);
		cur.setNext(in);
		size++;
	}
	
	public void dequeue() {
		if(Head != null && Head.getNext() != null){
			Node cur = Head.getNext();
			Node newNext = cur.getNext();
			Head.setNext(newNext);
		}
		size--;
	}
	
	public Node front() {
		if(Head != null && Head.getNext() != null){
			Node cur = Head.getNext();
			return cur;
		}
		return null;
	}
	
	public Object frontItem()  {
		if(Head != null && Head.getNext() != null){
			Node cur = Head.getNext();
			return cur.getItem();
		}
		return null;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		if(Head.getNext() == null) {
			return true;
		}
		return false;
	}
	
	public void printQueue() {		
		if(Head.getNext() != null) {
			Node cur = Head.getNext();
			for(int k=0; k<size;  k++) {
				System.out.print(cur.getItem()+" ");
				cur = cur.getNext();
			}
		}
	}
	
}
