import java.util.Random;

public class Test {
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		BinarySearchTree Bst = new BinarySearchTree();
		AugmentedBinarySearchTree Abst = new AugmentedBinarySearchTree();
		
		Node arr[]= new Node[1000];
		AugmentedNode arrs[] = new AugmentedNode[1000];
		RandomArray(arr, arrs);
		
		long starttime, endtime=0;
		
		
		starttime = System.nanoTime();
		for (int i = 0; i < arr.length; i++) {  //Nodes is inserted to BST
			Bst.insert(Bst, arr[i]);
		}
		endtime = System.nanoTime();
		
		System.out.println("------ BÝNARY SEARCH TREE ------");
		System.out.println("All items were inserted.");
		System.out.println("The time elapsed for the INSERTION of all items is " + (double)(endtime - starttime) + " nanoseconds" );
		
		int GetSumSmaller = Bst.GetSumSmaller(Bst.root, 1000);
		System.out.println("The result of GETSUMSMALLER for the item with value 1000 is " + GetSumSmaller);

		System.out.println("The maximum value of all items is " + Bst.GetMax(Bst.root).number);
		System.out.println("The minimum value of all items is " + Bst.GetMin(Bst.root).number);
		
		starttime = System.nanoTime();
		int GetSum = Bst.GetSum(Bst.root); //To find that sum of all nodes in BST
		endtime = System.nanoTime();
		
		System.out.println("The summation of all items is " + GetSum);
		System.out.println("The time elapsed for GETSUM is " + (double)(endtime - starttime) + " nanoseconds" );
		
		starttime = System.nanoTime();
		while (Bst.root!=null) {
			Bst.Delete(Bst, Bst.root); //To find that elapsed time for the deletion at BST
		}
		endtime = System.nanoTime();
		
		System.out.println("All items were deleted.");
		System.out.println("The time elapsed for the DELETION of all items is " + (double)(endtime - starttime) + " nanoseconds" );
		
		System.out.println();
		System.out.println();
		
		System.out.println(" ------- AUGMENTED BÝNARY SEARCH TREE ------  ");

		starttime = System.nanoTime();
		for (int i = 0; i < arr.length; i++) { //Augmented Nodes is inserted to ABST
			Abst.insert(Abst, arrs[i]);
		}
		endtime = System.nanoTime();
		
		System.out.println("All items were inserted.");
		System.out.println("The time elapsed for the INSERTION of all items is " + (double)(endtime - starttime) + " nanoseconds" );
		
		GetSumSmaller = Abst.GetSumSmaller(Abst.root, 1000);
		System.out.println("The result of GETSUMSMALLER for the item with value 1000 is " + GetSumSmaller);
		
		System.out.println("The maximum value of all items is " + Abst.GetMax(Abst.root).number);
		System.out.println("The minimum value of all items is " + Abst.GetMin(Abst.root).number);
		
		starttime = System.nanoTime();
		GetSum = Abst.GetSum(Abst.root);
		endtime = System.nanoTime();
				
		System.out.println("The summation of all items is " + GetSum);
		System.out.println("The time elapsed for GETSUM is " + (double)(endtime - starttime) + " nanoseconds" );
		
		
		starttime = System.nanoTime();
		while(Abst.root!=null){
			Abst.HolderUpdate(Abst.root.right, Abst.root.number); //Updating, holder field
			Abst.Delete(Abst, Abst.root);
		}
		endtime = System.nanoTime();
		
		System.out.println("All items were deleted.");
		System.out.println("The time elapsed for the DELETION of all items is " + (double)(endtime - starttime) + " nanoseconds" );
		
	}
	
	
	static void RandomArray(Node x[], AugmentedNode y[]) { //Create a node array by random number
		Random rnd = new Random();
		for (int i = 0; i < x.length; i++) {
			int rndm= rnd.nextInt(2000);
			x[i]= new Node(rndm);
			y[i]= new AugmentedNode(rndm);
		}

	}
	

}
