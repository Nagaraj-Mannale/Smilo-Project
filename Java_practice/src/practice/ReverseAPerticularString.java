package practice;

public class ReverseAPerticularString 
{
 public static void main(String[] args) {
	String Sentence="Nagraj is an automation Engineer";
	String [] split=Sentence.split(" ");
	for(int i=0;i<split.length;i++)
	{
		if(!split[i].equalsIgnoreCase("Engineer"))
		{
			System.out.print(split[i]+" ");
		}
		else
		{
			
			for(int j=split[i].length()-1;j>=0;j--)
			{
				System.out.print(split[i].charAt(j));
			}
		}
	}
	
	
}
}
