package main;
// singly-linked list

public class PolyNode {
	
	int coef;
	int exp;
	PolyNode next;
	PolyNode prev;


    public PolyNode(int coefficient, int exponent) {
    	coef = coefficient;
    	exp = exponent;
    	next = null;
    	prev = null;
    }
    
    public PolyNode(int coefficient, int exponent, PolyNode newNode) {
    	coef = coefficient;
    	exp = exponent;
    	next = newNode;
    	prev = null;
    }
    
    public PolyNode(int coefficient, int exponent, PolyNode prevNode, PolyNode nextNode) {
    	coef = coefficient;
    	exp = exponent;
    	next = nextNode;
    	prev = prevNode;
    }
    
    public void setItem(int coefficient, int exponent) {
    	coef = coefficient;
    	exp = exponent;
    }
    
    public int getCoef() {
    	return coef;
    }
    
    public int getExp() {
    	return exp;
    }
    
    public void setLinks(PolyNode prevNode, PolyNode nextNode) {
    	next = nextNode;
    	prev = prevNode;
    }
    
    public void setNext(PolyNode newNode) {
    	next = newNode;
    }
    
    public PolyNode getNext() {
    	return next;
    }
    
    public void setPrev(PolyNode newNode) {
    	prev = newNode;
    }
    
    public PolyNode getPrev() {
    	return prev;
    }
}