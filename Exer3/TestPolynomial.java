package main;

/**
 * 
 * Author: Ricardo Emmanuel M. Benitez
 * 
 */

import java.util.Scanner;

public class TestPolynomial {

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial(3);
		p1.createPolynomial();
		p1.display();
		p1.sortTerms();
//		p1.displayRaw(); // ENABLE TO SEE COMPLETE LIST
		p1.display();
		
//		Polynomial p2 = new Polynomial(3);
//		p2.createPolynomial();
//		p2.sortTerms();
//		p2.display();
		
		// defective
//		Polynomial p3 = new Polynomial();
//		p3.addPolynomials(p1, p2);
//		p3.display();
	}

}
