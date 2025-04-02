package practice;
import java.util.*;
public class AFindingAnGivenElementInArrays {
public static void main(String[] args) {
	int[]a= {10,20,30,40,50};
	boolean value=false;
	try (Scanner sc = new Scanner(System.in)) {
		System.out.println("Give the Input for Find");
		int b=sc.nextInt();
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==b)		
			{
				System.out.println("Given input is present in the Array");
				value=true;break;
			}	}
	}
	if(value==false)
	{
		System.out.println("Given input is not present in the Array");
	}
}
}
