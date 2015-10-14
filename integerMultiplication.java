
public class integerMultiplication {
	
	public long multiply(long x, long y)
	{
		//System.out.println("Hello");
		int size1=getSize(x);
		int size2=getSize(y);
		
		int N = Math.max(size1, size2);
		
		if (N==0) return 0;
		if(N==1) return x*y;
		
		N=(N/2)+(N%2);
		
		long m = (long)Math.pow(10, N);
		
		long a = x/m;
		long b = x - (a*m);
		long c = y/m;
		long d = y - (c*m);
		
		long z1 = multiply(a, c);
		long z2 = multiply(b, d);
		long z3 = multiply(a+b, c+d);
		
		return (z1 * (long)(Math.pow(10, 2*N))) + (z3-z1-z2)*m + z2;
		
	}
	
	public int getSize(long num) {
		int count=0;
		while(num != 0)
		{
			num=num/10;
			count++;
		}
		return count;
	}
	public static void main(String args[])
	{
		long n1=12345;
		long n2=5678;
		
		integerMultiplication im = new integerMultiplication();
		long result = im.multiply(n1,n2);
		
		System.out.println("The product is:"+result);
	}
}
