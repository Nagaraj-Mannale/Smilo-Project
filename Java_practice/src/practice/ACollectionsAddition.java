package practice;

import java.util.ArrayList;

public class ACollectionsAddition {
  public static void main(String[]args)
   {
	int a[]= {1,2,5};
	int b[]= {8,8,5};
	ArrayList<Integer>ab=new ArrayList<>();
	int carry=0;
	for(int i=0;i<a.length;i++)
	{
		int sum=a[i]+b[i]+carry;
		if(i!=a.length-1)
		{
			ab.add(sum%10);
			carry=sum/10;
		}
		else
		{
			ab.add(sum);
		}
	
	}
	System.out.println(ab);
	
   }
}
