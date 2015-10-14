class closet
	{
		public int findcrossover(int a[], int low, int high, int x)
		{
			if(x>=a[high])
				return high;
			if(x<=a[low])
				return low;
			
			int mid = (low+high)/2;
			
			if(a[mid]<=x && a[mid+1]>x)
				return mid;
			
			if(x<a[mid])
				return findcrossover(a, low, mid-1, x);
			else
				return findcrossover(a, mid+1, high, x);
			
		}
		
		public  void closest(int a[], int x, int k,int n)
		{
			int low=0;
			int high=n-1;
			
			int l=findcrossover(a, low, high, x);
			int r=l+1;
			
			if(a[l]==x)
				l--;
			
			int count = 0;
			while(l>=0 && r<n && count<k)
			{
				if(x-a[l] < a[r]-x)
					 System.out.println(a[l--]);
				else
					 System.out.println(a[r++]);
				
				count++;
			}
			
			while(l>=0 && count<k)
			{
				System.out.println("%d"+a[l--]);
				count++;
			}
			
			while(r<n && count<k)
			{
				System.out.println("%d"+a[r++]);
				count++;
			}
		}
}

public class closestpair {
		public static void main(String args[])
		{
			closet p2 = new closet();
			int a[]={23,26,28,29,33,35,39,41,43,51};
			int n = a.length;
			int x=35;
			p2.closest(a,x,6,n);
		}
}
