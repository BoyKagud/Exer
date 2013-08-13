package main;

import java.util.Scanner;

public class Polynomial {
	
	private int terms;
	private PolyNode Head;

	public Polynomial() {
		Head = new PolyNode(0, 0);
	}
	
	public Polynomial (int numTerms) {
		Head = new PolyNode(0, 0);
		terms = numTerms;
	}
	
	public int getTerms() {
		return terms;
	}
	
	public void setTerms(int numTerms) {
		terms = numTerms;
	}
	
	public void addTerm(int position) {
		Scanner in = new Scanner(System.in);		
		System.out.print("Enter coefficient and exponent: ");
		
		int coef = in.nextInt();
		int exp = in.nextInt();

		PolyNode node = new PolyNode(coef, exp);
		
		// traverse and update links
		if(Head.getNext() != null) {
			PolyNode cur = Head;
			PolyNode nodeAftPos = null;
			for(int k=0 ; k<position ; k++) {
				if(k == position-1) {
					nodeAftPos = cur.getNext();
					cur.setNext(node);
					node.setPrev(cur);
				}
				if(k == position) {
					nodeAftPos.setPrev(cur);
					cur.setNext(nodeAftPos);
				}
				cur = cur.getNext();
			}
		} else if(Head.getNext() == null && position == 1) {
			node.setLinks(Head, Head.getNext());
			Head.setNext(node);
		}
	}
	
	public void createPolynomial() {
		System.out.println("Enter a "+terms+"-term polynomial");
		for(int x=1 ; x<=terms ; x++) {
			System.out.println("Term "+x+":");
			addTerm(x);
		}
	}
	
	public void sortTerms() {
    	PolyNode cur = Head.getNext();
    	PolyNode toNext = null;
    	for(int l=1; l <= terms; l++) {
	        for(int j=1; j <= terms; j++) {
        		toNext = cur.getNext();
	        	if(cur.getNext() != null) {
//	        		System.out.println(cur.getExp()+" "+cur.getPrev().getExp());
	        		if(j>1 && cur.getExp() > cur.getPrev().getExp()) {
	        			PolyNode oneStep = cur.getPrev();
	        			PolyNode twoStep = cur.getPrev().getPrev();
	        			PolyNode oneForward = cur.getNext();
	        			oneStep.setLinks(cur, cur.getNext());
	        			twoStep.setNext(cur);
	        			cur.setLinks(twoStep, oneStep);
	        			oneForward.setPrev(oneStep);
	        		}
	        	} else {
	        		if(j>1 && cur.getExp() > cur.getPrev().getExp()) {
		    			PolyNode oneStep = cur.getPrev();
		    			PolyNode twoStep = cur.getPrev().getPrev();
		    			oneStep.setLinks(cur, cur.getNext());
		    			twoStep.setNext(cur);
		    			cur.setLinks(twoStep, oneStep);
	        		}
	        	}
	        	cur = toNext;
	        }	
	        cur = Head.getNext();
    	}
    	fillGaps();
	}
	
	public void fillGaps() {
		PolyNode cur = Head.getNext();
		int maxExp = cur.getExp();
		int reach = 0;
		for(int k=1 ; k < maxExp ; k++) {
			PolyNode toNext = cur.getNext();
			if(cur.getExp() > 0 && cur.getNext().getExp() != cur.getExp()-1) {
				PolyNode node = new PolyNode(0, cur.getExp()-1, cur, cur.getNext());
				cur.getNext().setPrev(node);
				cur.setNext(node);
				terms++;
			}			
			cur = toNext;
		}		
		
		cur = Head.getNext();
		for(cur = Head.getNext(); cur.getNext() != null ; cur = cur.getNext()) {
			reach++;
		}
		if(cur.getExp() > 0) {
			int goal = maxExp - reach;
			for(int k = goal ; k > 0 ; k--) {
				terms++;
				PolyNode node = new PolyNode(0, k-1, cur, null);
				cur.setNext(node);
			}
		}
		
	}
	
	public PolyNode getHead() {
		return Head;
	}

	public void display() {
		if(Head.getNext() != null) {
			PolyNode cur = Head.getNext();
			String res = "";
			for(int k=0 ; k<terms ; k++) {
				if(cur.getCoef() != 0) {
					res += cur.getCoef();
					switch(cur.getExp()) {
						case 1: res += "x";
								break;
						case 0: break;
						default:res += "x^"+cur.getExp(); 
								break;
					}
				}
				if(k < terms-1 && cur.getNext().getCoef() != 0) res += " + ";
				cur = cur.getNext();
			}
			System.out.println("The polynomial is:\t"+res+"\n");
		}
	}
	
	public void displayRaw() {
		if(Head.getNext() != null) {
			PolyNode cur = Head.getNext();
			String res = "";
			for(int k=0 ; k<terms ; k++) {
				res += cur.getCoef();
				res += "x^"+cur.getExp(); 
				if(k < terms-1) res += " + ";
				cur = cur.getNext();
			}
			System.out.println(res);
		}
	}
	
	public void traverse() {
		PolyNode cur = Head.getNext();
		String r = "";
		for(int y=0 ; y<terms ; y++) {
			r += cur.getExp()+" ";
			cur = cur.getNext();
		}
//		System.out.println(r);
	}
		
	public void addPolynomials(Polynomial pol1, Polynomial pol2) {
//		pol1.sortTerms();
//		pol2.sortTerms();
		int pol1Terms = pol1.getTerms();
		int pol2Terms = pol2.getTerms();
		PolyNode curPol1 = pol1.getHead().getNext();
		PolyNode curPol2 = pol2.getHead().getNext();
		
		if(pol1Terms > pol2Terms) terms = pol1Terms;
		else if(pol1Terms > pol2Terms) terms = pol2Terms;
		else if(pol1Terms == pol2Terms) terms = pol1Terms;
				
		int step = 0;
		for(curPol1 = pol1.getHead().getNext() ; curPol1.getNext() != null ; curPol1 = curPol1.getNext()) {
			
			if(step == 0 && pol1.getTerms() > pol2.getTerms()) {
				int gap = pol1.getTerms() - pol2.getTerms();
				for(int itr = 0 ; itr < gap ; itr++) {
					addTerm(step, curPol1.getCoef(), curPol1.getExp());
					curPol1 = curPol1.getNext();
				}
			}
		
			int sumCoef = curPol1.getCoef() + curPol2.getCoef();
			addTerm(step, sumCoef, curPol1.getExp());
			System.out.println(curPol1.getCoef()+" "+curPol1.getExp()+" - "+curPol2.getCoef()+" "+curPol2.getExp());
			
			step++;
			curPol2 = curPol2.getNext();
		}

	}
	
	public void addTerm(int position, int coef, int exp) {
//		System.out.println(coef+" "+exp);
		PolyNode node = new PolyNode(coef, exp);
		
		// traverse and update links
		if(Head.getNext() != null) {
			PolyNode cur = Head;
			PolyNode nodeAftPos = null;
			for(int k=1 ; k<=position ; k++) {
				if(k == position) {
					cur.getPrev().setNext(node);
					node.setLinks(cur.getPrev(), cur);
					cur.setPrev(node);
				}
				cur = cur.getNext();
			}
		} else if(Head.getNext() == null && position == 1) {
			node.setLinks(Head, Head.getNext());
			Head.setNext(node);
		}
	}
	
}
