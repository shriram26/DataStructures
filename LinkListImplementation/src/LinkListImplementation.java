public class LinkListImplementation {
	public static void main(String[] args) throws java.lang.Exception {
		LinkedListT a = new LinkedListT();

		a.addAtBegin(6);
		a.addAtBegin(33);
		a.addAtBegin(15);
		a.addAtEnd(20);
		a.addAtEnd(21);
		//a.search(20);
		a.deleteAtEnd();
		a.display();
//		a.deleteAtBegin();
//		a.display();
//		a.deleteAtEnd();
//		a.addAtIndex(10, 2);
//		a.addAtEnd(15);
//		a.display();
//		System.out.println("\n Size of the list is: " + a.size);
//		System.out.println(" Element at 2nd position : " + a.elementAt(2));
//		System.out.println(" Searching element , status : " + a.search(56));
	}
}
class Node {
	public int data;
	public Node link;

	public Node(int data) {
		this.data = data;
		this.link = null;
	}
}

class LinkedListT {
	public Node head;
	public Node tail;
	public int size;
	public LinkedListT() {
		head = null;
		tail = null;
		size = 0;

	}
	public void addAtBegin(int data) {
		Node n = new Node(data);
		n.link = head;
		head = n;
		size++;
	}
	public void deleteAtBegin() {

		Node n = head;
		head = head.link;
		n = null;
		size--;

	}
	public void deleteAtEnd() {
		
		if (head == null) {
			System.out.println("No item present in linked list");
		} 
		else if (head.link == null){
			head = null;
			size--;
		}
		else
		{
			Node currNode = head.link;
			Node trailCurrent = head;
			while(currNode.link!= null)
			{
				currNode = currNode.link;
				trailCurrent = trailCurrent.link;
			}
			trailCurrent.link = null;
			
			size--;
		}
	}







	public void deleteNode(int deleteItem)
	{
		Node current = head;
		Node trailCurrent = null;
		boolean found;


		if(head == null)//case 1
		{
			System.out.println("Cannot delete from a empty Link LIst");
		}

		else
		{
			if(head.data == deleteItem )//case 2 
			{
				current = head;
				head = head.link;
				size--;

				if(head == null)
				{
					tail = null;	
				}
				current = null;

			}

			else
			{
				found = false;
				trailCurrent = head;
				current = head.link;

				while(current != null && !found)
				{
					if(current.data != deleteItem)
					{
						trailCurrent = trailCurrent.link;
						current = current.link;
					}
					else
					{
						found = true;
					}
				}//end while

				if (found)
				{
					trailCurrent.link = current.link;
					size--;

					if(tail == current)
					{
						tail = trailCurrent;		
					}
					current = null;
				}

				else
				{
					System.out.println("The item to be deleted is not in the list");
				}

			}//end inner else 
		}//end outer else after very first if

	}//end deleteNode function

	public void addAtEnd(int data) {
		if (head == null) {
			addAtBegin(data);
		} else {
			Node n = new Node(data);
			Node currNode = head;
			while (currNode.link != null) {
				currNode = currNode.link;
			}
			currNode.link = n;
			size++;
		}
	}
	public int elementAt(int index){
		if(index>size){
			return -1;
		}
		Node n = head;
		while(index-1!=0){
			n=n.link;
			index--;
		}
		return n.data;
	}
	public int getSize(){
		return size;
	}
	public boolean search(int searchdata){
		Node current = head;
		boolean found = false;

		while(current!= null && !found){

			if(current.data == searchdata)
			{
				found = true;
			}
			else{
				current = current.link;
			}
		}

		return found;

	}
	public void addAtIndex(int data, int position){
		if(position == 1){
			addAtBegin(data);
		}
		int len = size;
		if (position>len+1 || position <1){
			System.out.println("\nINVALID POSITION");
		}
		if(position==len+1){
			addAtEnd(data);
		}
		if(position<=len && position >1){
			Node n = new Node(data);
			Node currNode = head; //so index is already 1
			while((position-2)>0){
				System.out.println(currNode.data);
				currNode=currNode.link;
				position--;
			}
			n.link = currNode.link;
			currNode.link = n;
			size++;
		}
	}
	public void display() {
		System.out.println("");
		Node currNode = head;
		while (currNode != null) {
			System.out.print("->" + currNode.data);
			currNode = currNode.link;
		}
	}
}