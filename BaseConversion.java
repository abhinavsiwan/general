public class BaseConversion {
	
	public int digitToValue(char c)
	{
		if(c>='0' && c<='9') return c-'0';
		else if(c>='A' && c<='F') return 10+c-'A';
		else if(c>='a' && c<='f') return 10+c-'a';
		return -1;
	}
	public int convertToBase(String number,int base)
	{
		int value=0;
		for(int i=number.length()-1;i>=0;i--)
		{
			int digit = digitToValue(number.charAt(i));
			int exp=number.length()-1-i;
			value+=digit*Math.pow(base,exp);
		}
		return value;	
	}
	public static void main(String args[])
	{
		BaseConversion base=new BaseConversion();
		int result=base.convertToBase("0110",2);
		System.out.println(result);
	}
}
