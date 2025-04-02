package practice;

public class OtpSending {
public static void main(String[] args) {
	String otp="12345";
	int i=0;
	int[]a= {1,2,3,4,5,6};
	for(int b:a)
	{
		while(i<otp.length())
		{
			System.out.println(b+""+Character.toString(otp.charAt(i)));
			i++;
			break;
		}
	}
}
	
}
