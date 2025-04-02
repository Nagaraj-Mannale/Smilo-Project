package practice;
   
	public class static_Non_staic_classvariable {
		 // Initializing the class variable through constructor, Non static method and static method	
		
//		int b=10; //Once class variable declared, immediately we can not reinitialized it
//		Javabasics()    //Constructor will allow to initialize the class members.
//		{
//			System.out.println(b);
//			b=20;
//		}
//	    public void mymethod()
//	     {
//		  b=30;
//		  b=40;    //we can initialize the class variable from non static method   
//      	 }
//		public static void main(String[] args) {
//			final int a=10;  //Once we declare a variable with the final keyword that value will be constant, it will not get change
//			static_Non_staic_classvariable  c= new static_Non_staic_classvariable ();   //To call || initialize the class variable from the static member we have to create an object	
//			System.out.println(c.b);
//			c.b=30;
//			c.mymethod(); //We call the non static methods in static method with the help of object 
//			System.out.println(c.b);
//			System.out.println(a);
//			
//		}
		
		static int b=10; //static it self is an class variable it provide the same value for through out the methods until it gets change
		final int f;
		static_Non_staic_classvariable()
		{
			f=20;
		}
		public void plus()
		{
			//f=20;
		 int sum=10+b;
		 System.out.println(sum);
		}
		public void reinitalize()
		{
			int c=20;
			b=c;
			System.out.println(b);
		}
		public static void minus()
		{
			System.out.println(b-10);
		}
		public static void main(String[] args) 
		{
			System.out.println(b);          //static method directly calls the static variable without creating an objects 
			
			static_Non_staic_classvariable  j=new static_Non_staic_classvariable();  //to call the non static members from static we have to create an object 
			j.plus();
			j.reinitalize();
			j.plus();
			
			minus();//calling a static member from static methods no need to required the object creation
			
			
		}
		
		
		
	}
