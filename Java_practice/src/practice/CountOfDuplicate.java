package practice;


import java.util.Scanner;

public class CountOfDuplicate {
public static void main(String[] args) {
   int[]a= {10,20,10,30,40,50};
  
   int count=0;
   try (Scanner scanner = new Scanner(System.in)) {
	System.out.println("Give the input");
	   int b=scanner.nextInt();
	   for(int i=0;i<a.length;i++)
	   {
		   if(a[i]==b)
		   {
			   count++;
		   }
	   }
	   System.out.println(b+" is "+count+ " times repeated in the given array");
}
}
}
