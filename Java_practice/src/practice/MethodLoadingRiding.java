package practice;

public class MethodLoadingRiding 
{
//Method overloading and Method Overriding
    void name()
    {
	System.out.println("Empty");
    }
    
	void name(String a)
	{
		System.out.println(a);
	}
	 
	void name(String b, String c)
	{
		System.out.println(b+c);
	}
	
	void name(int c,String b)
	{
		System.out.println(c+b);
	}
	public static void main(String[] args) {
		MethodLoadingRiding MLR=new MethodLoadingRiding();
		MLR.name();
		MLR.name("My name is lakhan");
        MLR.name("Nanu","Ninu");
        MLR.name(4,"Nandu");
	}
}
