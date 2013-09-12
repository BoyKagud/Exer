package exer6;

import com.sun.org.apache.xerces.internal.impl.io.ASCIIReader;

public class HashTable {
	
	private DataItem hashArray[];
	private int arraySize;
	
	public HashTable(int size) {
		arraySize = size;
		hashArray = new DataItem[arraySize];
	}
	
	//You may customize the way you want your hash table to be displayed
	public void displayTable() {
		System.out.println("\nHash Table of size " + arraySize + "\n");
		for(int j=0; j<arraySize; j++) {
			if(hashArray[j] != null)
				System.out.println(j + "| " + hashArray[j].getStrFrm());
			else
				System.out.println(j + "| ** ");
		}
		System.out.println("");
	}
	
	public int hashFunc(int key) {
		return key % arraySize; 
	}
	
	public void insert(String uname, String pword) {
            if(!isFull()) {
		DataItem hashItem = new DataItem(getIntVal(pword), uname);
                int key = hashItem.getKey();
                if(hashArray[key] == null) hashArray[key] = hashItem;
                else {
                    boolean wraped = false;
                    for(int hsi=key ; hsi<arraySize ; hsi++) {
                        int pos = hashFunc(hsi);
                        if(hashArray[pos] == null) {
                            hashArray[pos] = hashItem;
                            return;
                        }
                        
                        // last
                        if(hsi == arraySize-1 && wraped == false) {
                            hsi =-1;
                            wraped = true;
                        } 
                    }
                }
            }
            else System.out.println("ERROR: Hash table is full");
        }
                
        public int getIntVal(String item) {
            item = item.toUpperCase();
            int intVal = 0;
            char[] alpha = {'A', 'B', 'C', 'D', 'E', 
                            'F', 'G', 'H', 'I', 'J', 
                            'K', 'L', 'M', 'N', 'O', 
                            'P', 'Q', 'R', 'S', 'T', 
                            'U', 'V', 'W', 'X', 'Y', 'Z'};
            for (int y=0 ; y<item.length() ; y++) {
                for(int k=0 ; k<alpha.length ; k++) {
                    if(alpha[k] == item.charAt(y)) intVal += k;
                }
            }
            return hashFunc(intVal);
        }
        
        public boolean isFull() {
            boolean full = true;
            for(int s = 0 ; s<arraySize ; s++) {
                if(hashArray[s] == null) full = false;
            }
            return full;
        }
	
	// You may also add your own methods in this class	
}