
public class BinarySearchTree {
	public Node root;
	int GetSumSmaller=0;
	int GetSum=0;

	public void insert(BinarySearchTree T,Node z){
		Node y=null;
		Node x=T.root;
		while(x!=null){
			y=x;
			if(z.number < x.number)
				x=x.left;
			else
				x=x.right;
		}
		z.parent=y;
		if(y==null)
			T.root=z;//tree was empty
		else if(z.number<y.number)
			y.left=z;
		else
			y.right=z;
	}

	public void Transplant (BinarySearchTree T, Node u, Node v){
		if(u.parent==null)
			T.root=v;
		else if(u==u.parent.left)
			u.parent.left=v;
		else
			u.parent.right=v;
		if (v!=null)
			v.parent=u.parent;
	}

	public Node GetMin(Node x){
		while(x.left!=null)
			x=x.left;
		return x;
	}

	public Node GetMax(Node x){
		while(x.right!=null)
			x=x.right;
		return x;
	}

	public int GetSum (Node x){
		if(x!=null){
			GetSum(x.left);
			GetSum+=x.number;
			GetSum(x.right);
		}
		return GetSum;
	}

	public int GetSumSmaller(Node x,int number){
		if(x!=null){
			GetSumSmaller(x.left, number);
			if(x.number<number){
				GetSumSmaller+=x.number;
			}
			GetSumSmaller(x.right, number);
		}
		return GetSumSmaller;
	}
	
	public void Delete(BinarySearchTree T, Node z){
		Node y;
		if(z.left==null)             //z has no left child
			Transplant(T, z, z.right);
		else if(z.right==null)		 //z has just left child
			Transplant(T, z, z.left);
		else {						 //z has two child
			y=GetMin(z.right);		 //y is z's successor
			if(y.parent!=z){
				Transplant(T, y, y.right);
				y.right=z.right;
				y.right.parent=y;
			}
			Transplant(T, z, y);
			y.left=z.left;
			y.left.parent=y;
		}
	}
	
	public void Print(Node x){ 
		if(x!=null){
			Print(x.left);
			System.out.print(x.number + ", ");
			Print(x.right);
		}
	}

}
