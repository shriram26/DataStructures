
public class InOrderSuccessorWithoutParent {




	public Node search(Node root,int inputdata)
	{

		if(root == null)
		{
			System.out.println("empty tree");
			return null;
		}
		Node current = root;
		Node trailcurrent = null;
		while(current != null )
		{
			if(current.data == inputdata)
			{
				if(current.right != null)//case 3 & 4 right branch present
				{
					Node rightbranch = current.right;
					if(rightbranch.left == null)
					{
						return rightbranch;
					}
					else
					{
						while(rightbranch.left  != null	)
							rightbranch = rightbranch.left;
						return rightbranch;
					}

				}
				else // case 1 & 2 no right branch
				{
					return trailcurrent;
				}
			}
			else if ( current.data > inputdata)
			{
				trailcurrent = current;;
				current = current.left;
			}
			else
			{   
				//dont move trail current while moving right
				current = current.right;
			}
		}
		return null;
	}





	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}


	public static void main(String args[]){
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.left.left = new Node(3);
		root.right.left = new Node(13);

		Node a = new Node(7);
		root.left.right = a;

		System.out.print(" Tree : ");

		InOrderSuccessorWithoutParent b = new InOrderSuccessorWithoutParent();
		b.display(root);
		System.out.println();
		Node x = b.search(root, 10);
		Node yourNode = b.search(root,15);
		System.out.println("InOrder Successor of 17 "  + " is " +yourNode.data );






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


