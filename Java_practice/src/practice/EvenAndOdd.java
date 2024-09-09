package practice;

import java.util.ArrayList;

public class EvenAndOdd {
public static void main(String[] args) {
	int []a= {1,2,3,4,5,6};
	   ArrayList<Integer> evenList = new ArrayList<>();
       ArrayList<Integer> oddList = new ArrayList<>();
	for(int i=0;i<a.length;i++)
	{
		if(a[i]%2==0)
		{
			evenList.add(a[i]);
		}
		else {
			oddList.add(a[i]);
		}
	}
	System.out.println(evenList);
	System.out.println(oddList);
}
}
