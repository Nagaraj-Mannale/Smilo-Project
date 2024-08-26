package practice;

import java.util.Arrays;

public class ReverseParticularword 
{

    public static void main(String[] args) {
      
      String [] array = {"mango","banana","apple","pineapple"};
      
      for(int i=0; i<array.length; i++){
         String Store=array[i];
         String Reverse = "";
         if(array[i]=="banana")
         {
          for(int j=Store.length()-1; j>=0; j--)
           {
             Reverse += Store.charAt(j);
           }
         }
         else
         {
             Reverse +=array[i];
         }
         array[i] = Reverse;
      }
      System.out.println(Arrays.toString(array));
    }
}

