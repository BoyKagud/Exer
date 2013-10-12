package main;

public class Heap {
	
	Node[] heap;
	
	public Heap() {
		heap = new Node[1];
		heap[0] = null;
	}
	
	public void insert(int key, String info) {
		// clone heap + 1 and assign clone to heap
		Node[] newHeap = new Node[heap.length+1];
		for(int k=0 ; k<heap.length ; k++) {
			newHeap[k] = heap[k];
		}
		heap = newHeap;
		
		// create new Node at the last index of array
		int newPos = heap.length-1;
		Node newNode = new Node(key, info);
		heap[newPos] = newNode;
		
		//percolate Up
		int parent = (int) Math.floor(newPos/2);
		percolateUp(parent, newPos);
	}
	
	public void display() {
		for(int k = 0 ; k<heap.length ; k++) {
			if(heap[k] != null)
				System.out.println(heap[k].info+" - "+k);
		}
	}
	
	private void percolateUp(int parentOfBlankNodePos, int blankNodePos) { 
		while(heap[parentOfBlankNodePos] != null && heap[blankNodePos].key < heap[parentOfBlankNodePos].key) { // Percolate up
			Node danglingNode = heap[blankNodePos];
			heap[blankNodePos] = heap[parentOfBlankNodePos];
			heap[parentOfBlankNodePos] = danglingNode;
			blankNodePos = parentOfBlankNodePos;
			parentOfBlankNodePos = (int) Math.floor(parentOfBlankNodePos/2);
		}
	}
	
	public void deleteMin() {
		if(heap.length-1 >= 2) {
			// clone heap - 1
			Node[] newArrHeap = new Node[heap.length-1];
			newArrHeap[0] = null;
			newArrHeap[1] = null;
			for(int itr=2 ; itr<newArrHeap.length ; itr++) {
					newArrHeap[itr] = heap[itr];
			}
			// catch dangling Node
			Node danglingNode = heap[heap.length-1];
			heap = newArrHeap;
			
			// percolate down
			if(heap.length-1 != 2)
				percolateDown(danglingNode);
			else {
				if(danglingNode.key < heap[2].key)
					heap[1] = danglingNode;
				else {
					Node tmp = heap[2];
					heap[2] = danglingNode;
					heap[1] = tmp;
				}
			}
		} else {
			heap = new Node[1];
			heap[0] = null;
		}
	}
	
	private void percolateDown(Node danglingNode) {
		int parent = 1;
		heap[parent] = danglingNode;
		    while ((parent * 2) <= heap.length-1) {
		    	int mc;
		    	if( (parent * 2)+1 <= heap.length-1 && heap[parent * 2].key <= heap[(parent * 2)+1].key)
		    		mc = parent * 2;
		    	else if((parent * 2)+1 > heap.length-1) {
		    		heap[parent] = danglingNode;
		    		return;
		    	}
		    	else 
		    		mc = (parent*2)+1;
		    	
		        if (heap[parent].key > heap[mc].key) {
		            heap[parent] = heap[mc];
		            heap[mc] = danglingNode;
		        } else {
		        	heap[parent] = danglingNode;
		        }
		        parent = mc;
		    }
	}
	
	public int getSize() {
		return heap.length;
	}
	
	public Node getMin(){
		return heap[1];
	}
	
	public void printList() {
		Node[] clone = heap;
		System.out.println("\nDelivery List according to priority");
		int count=1;
		for(int k=0; k<5; k++, count++) {
			String min = getMin().info;
			deleteMin();
			System.out.println(count+".) "+min);
		}
		heap = clone;
		System.out.print("\n");
	}
	
	public boolean isEmpty() {
		if(heap.length < 2)
			return true;
		return false;
	}

	public void decreaseKey(int index) {
		for(int k=1 ; k<heap.length-1 ; k++) {
			if(heap[k].key == heap[index].key) {
				int decreaseNum = (int)Math.floor(Math.random()*(heap[k].key));
				heap[k].key -= decreaseNum;
				System.out.println("\nIncreased priority of "+heap[k].info+" by "+decreaseNum);
				percolateUp((int)Math.floor(k/2), k);
				return;
			}
		}
	}
	
}