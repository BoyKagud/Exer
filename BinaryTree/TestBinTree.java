package exer4;

public class TestBinTree {
	
	public static void main(String[]a) {
	
		BinTree T = new BinTree();
	
		T.insert(4);
		T.insert(17);
		T.insert(2);
		T.insert(30);
		T.insert(26);
		T.insert(21);                
			T.insert(1);
                T.insert(3);

		T.displayPreorder();
		System.out.println("Sum = "+T.getSum());
		
		if(T.contains(17))
			System.out.println("key found!");
		else	
			System.out.println("key not found!");
	}
}