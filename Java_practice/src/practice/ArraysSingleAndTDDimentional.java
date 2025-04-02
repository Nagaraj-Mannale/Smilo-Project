package practice;

import java.util.Arrays;

public class ArraysSingleAndTDDimentional {
public static void main(String[] args) {
	//1.Declaration
	    int a[]=new int[2];    
	
	//2.Initialization
   	    a[0]=10;
	    a[1]=20;
	    
	//3.Fetch size
	    System.out.println(a.length);
	                                                                       System.out.println();
	//4.Fetch particular number    
	    System.out.println(a[1]);
	                                                                       System.out.println();
	//5.Fetch all number by Pre-defined library
	    System.out.println(Arrays.toString(a)); 
	                                                                       System.out.println();
	//6.Fetch all number by For Loop
	    for(int i=0;i<a.length;i++)
	    {
	    	System.out.println(a[i]);
	    }
	                                                                       System.out.println();
	//7.Fetch all number by For Each loop or Enhanced loop    
	    for(int b:a)
	    {
	    	System.out.println(b);
	    }
	                                                                       System.out.println();
//TD Dimensional Arrays
	    
	//1.Declaration
	    int TD[][]=new int[2][3];
	                                                                     
	//2.Initialization
	    TD[0][0]= 1;
	    TD[0][1]= 2;
	    TD[0][2]= 3;
	    TD[1][0]= 4;		
	    TD[1][1]= 5;
	    TD[1][2]= 6;
	                                                                       System.out.println();
	//3.Get Single Specified value output
	    System.out.println(TD[0][1]);
	                                                                       System.out.println();
	//4.Get size of rows
	    System.out.println(TD.length);
	                                                                       System.out.println(); 
	//5.Get size of columns of specified rows
	    System.out.println(TD[0].length);
	                                                                       System.out.println();
	//6.Get output of all values by for-loop
	    for(int i=0;i<TD.length;i++)
	    {
	    	for(int j=0;j<TD[i].length;j++)
	    	{
	    		System.out.print(TD[i][j]+ " ");
	    	}
	    	System.out.println();
	    }
	        
	                                                                         System.out.println();                                                 
	//7.Get out off all values by for-each/Enhanced for loop        
	    for(int data[]:TD)
	    {
	    	for(int x:data)
	    	{
	    		System.out.print(x+ " ");
	    	}
	    	System.out.println();
	    }
}
	
}
