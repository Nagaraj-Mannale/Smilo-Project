package basePage;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringGenerator 
{
 public static void main(String[] args) {
	String gen=RandomStringUtils.randomAlphanumeric(3);
	System.out.println("test"+gen.toLowerCase()+"@gmail.com");
 }
}
