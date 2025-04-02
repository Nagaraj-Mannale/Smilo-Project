package practice;

public class VerifyAllParams {
	
	public static void verify(int one,int two)
	{
		for(int i=0;i<8;i++)
		{
			switch (i)
			{
			case 1:System.out.println("pass");break;
			case 2:System.out.println("pass");break;
			}
		}
	}
//		for(int i=0;i<8;i++)
//		{
//			if(i==one)
//			{
//				System.out.println("pass");
//			}
//			else if(i==two)
//			{
//				System.out.println("pass");
//			}
//		}
//	}
	public static void main(String[] args) 
	{
		verify(1,2);
	}

}
