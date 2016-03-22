
public class InOrderSuccessorWithParentPointer {
	
	public Node findInOrderSuccessor(Node root, Node x){
		//if the right child of x is not null then in-Order successor will the left most node in
		//the right sub tree of x.
		
		
		if(x.right!=null){
			return leftMostNode(x.right);//captures case 3 & 4
		}
		Node parent = x.parent;
		while(parent!=null && x==parent.right){ //captures cases 1 & 2
			x = parent;
			parent = parent.parent;
		}
		return parent;
	}
	public Node leftMostNode(Node x){
		while(x.left!=null){
			x = x.left;
		}
		return x;
	}
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}
	
	public Node search(Node root,int inputdata)
	{
		if(root == null)
		{
			return null;
		}
		if(root.data == inputdata)
		{
			return root;
		}
		
		Node left = search(root.left,inputdata);
		if(left != null)
		{
			return left;
		}
		Node right = search(root.right,inputdata);
		if(right != null)
		{
			return right;
		}
		return null;
	}
	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(5);
		root.left.parent = root;
		root.right = new Node(15);
		root.right.parent = root;
		root.left.left = new Node(3);
		root.left.left.parent = root.left;
		root.right.left = new Node(17);
		root.right.left.parent = root.right;
		Node a = new Node(7);
		root.left.right = a;
		root.left.right.parent = root.left;
		
		InOrderSuccessorWithParentPointer b = new InOrderSuccessorWithParentPointer();
		
		System.out.print(" Tree : ");
		b.display(root);
		System.out.println();
		
		Node yourNode = b.search(root,10);
		System.out.println("LLLLLLLL"+yourNode.data);
		
		Node answer = b.findInOrderSuccessor(root, yourNode);
		System.out.println("InOrder Successor of " + yourNode.data + " is " +answer.data );
		
		
		
		
		
	
	}
}
class Node{
	int data;
	Node left;
	Node right;
	Node parent;
	public Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
	}
}