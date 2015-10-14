public class RevereseLast5nodes {
	
	private Node first;
	
	public static class Node
	{
		int value;
		Node next;
		
		Node(int n)
		{
			this.value=n;
		}
	}
	
	//Insert Rear
		public Node Insert_rear(Node first,Node node)
		{
			if(first==null)
			{
				return node;
			}
			Node temp=first;
			while(temp.next!=null)
			{
				temp=temp.next;
			}
			temp.next=node;
			return first;
		}
	public Node reverse(Node first)
	{
		if(first==null)
			return null;
		
		Node temp,cur;
		cur=null;
		
		while(first!=null)
		{
			temp=first.next;
			first.next=cur;
			cur=first;
			first=temp;
		}
		return cur;
	}

	public Node reversekthnode(Node first,int k)
	{
		if(first==null)
			return null;
		
		Node cur=first;
		int noofNodes=1;
		//Count noofNodes in linklist
		while(cur.next!=null)
		{
			cur=cur.next;
			noofNodes++;
		}

		if(noofNodes<=k)
		{
			first=reverse(first);
		}
		else
		{
			Node ptr1;
			int startnode=noofNodes-k;
			ptr1=first;
			//Move to start and set pointer suppose ptr1 to n-5 positions.
			for(int i=0;i<startnode-1;i++)
			{
				ptr1=ptr1.next;
			}
			//pass ptr1.next to reverse function 
			Node ptr2=reverse(ptr1.next);
			//ptr1.next=return value of reverse function.
			ptr1.next=ptr2;
		}
		return first;
	}
	
	public void display(Node first)
	{
		if(first==null)
		{
			System.out.println("List is Empty");
			return;
		}
		
		Node temp=first;
		while(temp!=null)
		{
			System.out.print(temp.value+" ");
			temp=temp.next;
		}
	}
	
	public static void main(String args[])
	{
		RevereseLast5nodes list = new RevereseLast5nodes();
		Node first=null;
		for(int i=1;i<8;i++)
		{
			first=list.Insert_rear(first,new Node(i));
		}
		System.out.print("Original List:");
		list.display(first);
		System.out.println();
		System.out.print("Reversed List:");
		first=list.reversekthnode(first,5);
		list.display(first);
	}
}
