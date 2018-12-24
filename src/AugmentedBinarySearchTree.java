
public class AugmentedBinarySearchTree {
	public AugmentedNode root;
	int GetSumSmaller = 0;

	public void insert(AugmentedBinarySearchTree T, AugmentedNode z){
		AugmentedNode y=null;
		AugmentedNode x= T.root;
		while(x!=null){
			y=x;
			if(z.number < x.number) {
				x.holder+=z.number;
				if (x.right!=null) {
					HolderAdd(x.right, z.number);
				}
				x= x.left;
			}
			else{
				z.holder=x.holder+x.number;
				x= x.right;
			}		
		}
		z.parent=y;
		if(y==null)
			T.root=z;//tree was empty
		else if(z.number<y.number)
			y.left=z;
		else
			y.right=z;
	}

	static void HolderAdd (AugmentedNode x, int number){
		if(x!=null){
			HolderAdd( x.left, number);
			x.holder+=number;
			HolderAdd( x.right, number);
		}
	}

	public void Transplant (AugmentedBinarySearchTree T, AugmentedNode u, AugmentedNode v){
		if(u.parent==null)
			T.root=v;
		else if(u==u.parent.left)
			u.parent.left=v;
		else
			u.parent.right=v;
		if (v!=null)
			v.parent=u.parent;
	}

	public void Delete(AugmentedBinarySearchTree T, AugmentedNode z){
		AugmentedNode y;
		
		if(z.left==null) {            
			Transplant(T, z,  z.right);
		}
		else if(z.right==null)		 
			Transplant(T, z, z.left);
		else {						 
			y=GetMin(z.right);		 //y is root's successor
			if(y.parent!=z){
				Transplant(T,  y, y.right);
				y.right= z.right;
				y.right.parent=y;
			}
			Transplant(T, z, y);
			y.left=z.left;
			y.left.parent= y;
		}
		
	}

	public int GetSum(AugmentedNode x){
		while(x.right!=null)
			x= x.right;
		return x.holder+x.number;
	}

	public int GetSumSmaller(AugmentedNode x,int number){
		if(x!=null){
			GetSumSmaller(x.left, number);
			if(x.number<number){
				GetSumSmaller+=x.number;
			}
			GetSumSmaller(x.right, number);
		}
		return GetSumSmaller;
	}
	
	public AugmentedNode GetMin(AugmentedNode x){
		while(x.left!=null)
			x= x.left;
		return x;
	}

	public AugmentedNode GetMax(AugmentedNode x){
		while(x.right!=null)
			x= x.right;
		return x;
	}

	public void Print(AugmentedNode x){ 
		if(x!=null){
			Print( x.left);
			System.out.print(x.number + ", ");
			Print( x.right);
		}
	}

	public void HolderUpdate (AugmentedNode x, int number){
		if(x!=null){
			HolderUpdate( x.left, number);
			x.holder=x.holder-number;
			HolderUpdate( x.right, number);
		}
	}
}
