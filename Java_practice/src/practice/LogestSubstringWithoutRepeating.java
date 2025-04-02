package practice;

import java.util.HashSet;

public class LogestSubstringWithoutRepeating {

    public static void main(String[] args) {
        String ab = "abcabaedebc";
        int maxLength = 0;//1
        String result = "";

        // Using a HashSet to store unique characters
        HashSet<Character> charSet = new HashSet<>();
        int left = 0; // To track the start index of the current substring
        
        // Loop through the string with 'right' as the current character index
        for (int i = 0; i < ab.length(); i++) {//1
            // If character is already in the set, remove characters from left until it's removed
            while (charSet.contains(ab.charAt(i))) {
                charSet.remove(ab.charAt(left));//+0
                left++;
            }
            // Add the current character to the set
            charSet.add(ab.charAt(i));//ab
            
            // Update the result if the current window is larger than the previous one
            if (i - left + 1 > maxLength) {
                maxLength = i - left + 1;
                result = ab.substring(left, i + 1);
            }
        }
        
        System.out.println("Length of longest substring: " + maxLength);
        System.out.println("Longest substring: " + result);
    }
}
