
public class unimodalLargest {

	public int findMax(int a[],int low, int high)
	{
		if(low>high) return a[low+1];
		if(low==high) return a[low];
		
		int mid=(low+high)/2;
		//int mid=low + (high - low)/2;
		
		if(mid < high && a[mid]>a[mid+1])
			return a[mid];
		if(mid > low &&a[mid]<a[mid-1])
			return a[mid-1];
		
		if(a[low]>=a[mid])
			return findMax(a, low, mid-1);
		else
			return findMax(a, mid+1, high);

	}
	

	public int findMin(int a[],int low, int high)
	{
		if(low>high) return a[low];
		if(low==high) return a[low];
		
		int mid=(low+high)/2;
		
		if(mid < high && a[mid]>a[mid+1])
			return a[mid+1];
		if(mid > low && a[mid]<a[mid-1])
			return a[mid];
		
		if (a[high] > a[mid])
			return findMin(a, low, mid-1);
		else
			return findMin(a, mid+1, high);
	}
	/*
	int findMin(int arr[], int low, int high)
	{
	    // This condition is needed to handle the case when array is not
	    // rotated at all
	    if (high < low)
	    	return arr[0];
	 
	    // If there is only one element left
	    if (high == low) return arr[low];
	 
	    // Find mid
	    int mid = low + (high - low)/2;
	 
	    // Check if element (mid+1) is minimum element. Consider
	    // the cases like {3, 4, 5, 1, 2}
	    if (mid < high && arr[mid+1] < arr[mid])
	       return arr[mid+1];
	 
	    // Check if mid itself is minimum element
	    if (mid > low && arr[mid] < arr[mid - 1])
	       return arr[mid];
	 
	    // Decide whether we need to go to left half or right half
	    if (arr[high] > arr[mid])
	       return findMin(arr, low, mid-1);
	    return findMin(arr, mid+1, high);
	}
	*/
	public static void main(String args[])
	{
		int a[]={2,1};
		int size=a.length;
		
		unimodalLargest ul=new unimodalLargest();
		int largest= ul.findMax(a,0,size-1);
		int smallest= ul.findMin(a,0,size-1);
		System.out.println("Largest Number is:"+largest);
		System.out.println("Smallest Number is:"+smallest);
	}
}
