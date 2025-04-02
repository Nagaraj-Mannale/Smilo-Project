package practice;

public class FindingIndicesInArray {
public static void main(String[] args) {
	int [] a= {1,2,3,4,3,5,1};
	int target=6;
	for(int i=0;i<a.length;i++)
	{
		for(int j=i+1;j<a.length;j++)
		{
			if(a[i]+a[j]==target && i!=j)
			{
				System.out.println("["+i+","+j+"]");
				
		}	}
		
	}   }   }
