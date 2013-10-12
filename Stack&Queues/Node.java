package main;
// singly-linked list

public class Node {
	
	private Object item;
	private Node next;

    public Node(Object newItem) {
    	item = newItem;
    	next = null;
    }
    
    public Node(Object newItem, Node newNode) {
    	item = newItem;
    	next = newNode;
    }
    
    public void setItem(Object newItem) {
    	item = newItem;
    }
    
    public Object getItem() {
    	return item;
    }
    
    public void setNext(Node newNode) {
    	next = newNode;
    }
    
    public Node getNext() {
    	return next;
    }
}