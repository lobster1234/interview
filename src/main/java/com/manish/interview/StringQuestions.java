package com.manish.interview;

import java.util.*;

/**
 * Created by mpandit on 1/26/15.
 */
public class StringQuestions {

    public static void main(String ... args){
        System.out.println(contains("abc", "abc"));
        System.out.println(contains("abcd", "abc"));
        System.out.println(contains("abc", "abcd"));
        System.out.println(contains("a", "bddadcf"));
        System.out.println(reverseInPlace("Manish"));
        System.out.println(reverseInPlace("Tanvi"));
        System.out.println(filterDuplicates("Manish Pandit"));
        System.out.println("Recursive reverse " + reverseRecursion("Manish"));
        System.out.println("Change lower to upper in string abCdefg " + convertLowerToUpper("abCdefg"));
        System.out.println("Switch cases for aBcDeFgH is " + switchCases("aBcDeFgH"));
        System.out.println("The numeric value of abc is " + getNumericValue("abc"));
        System.out.println("The numeric value of -123 is " + getNumericValue("-123"));
        System.out.println("The numeric value of -12-3 is " + getNumericValue("-12-3"));
        System.out.println("The numeric value of +123 is " + getNumericValue("+123"));
        System.out.println("The numeric value of 123 is " + getNumericValue("123"));
        System.out.println("Clean string with abc and bcd is " + cleanSecondString("abc","bcd"));
        System.out.println("Clean string with abc and pqr is " + cleanSecondString("abc","pqr"));
    }


    /**
     * Check if string2 is an contains of string 1
     * @param string1 First input
     * @param string2 Second input
     * @return true if string2 contains string1
     */
    public static boolean contains(String string1, String string2){
        if(string1==null || string2==null) return false;
        //for string1 to be an anagram of string2, it should have all characters in string2
        //we can stick the string2 in a hashset and then do a contains() for each character of string1
        HashSet<Character> c = new HashSet();
        //Space = N2, Time = N2
        for(char x:string2.toCharArray()){
            c.add(x);
        }
        //now we do a for loop to check anagram
        //Space = N/A, Time = N1 worst case
        boolean contains = true;
        for(char y:string1.toCharArray()){
            if(!c.contains(y)){
                contains = false;
                break;
            }
        }
        //Total Space = N2, Total Time = N1 + N2
        return contains;
    }

    public static String reverseInPlace(String input){
        char[] array = input.toCharArray();
        int frontIndex = 0;
        int lastIndex = input.length()-1;
        while(frontIndex<=lastIndex){
            char temp = array[frontIndex];
            array[frontIndex] = array[lastIndex];
            array[lastIndex] = temp;
            ++frontIndex;
            --lastIndex;
        }
        return new String(array);
    }

    /**
     * Remove duplicates from a given string
     * @param string The input string
     * @return filtered out string with no duplicates
     */
    public static String filterDuplicates(String string){
        //we use linkedhashset as we need to maintain the order, otherwise we can use hashset
        LinkedHashSet<Character> set = new LinkedHashSet();
        for(char c:string.toCharArray()){
            set.add(c);
        }
        //convert the set to string
        StringBuilder builder = new StringBuilder();
        for(char c: set){
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * Reverse a string using recursion.
     * We can use the fact that reverse of a string is its last character + the reverse of the rest.
     * @param input The input string
     * @return the reversed string
     */
    public static String reverseRecursion(String input){
        if(input.length() <= 1) return input;
        else //end index is exclusive, I learned the hard way. So input.length() is fine for endindex.
            return input.substring(input.length()-1,input.length()) + reverseRecursion(input.substring(0,input.length()-1));
    }

    /**
     * Convert lower case characters to upper case characters.
     * Per ASCII table A is 65, a is 97.
     * B is 11, b is 62, so a delta of 32
     * So, subtracting 32 from the lower case will return the upper case.
     * We do not need to remember 32, we can get it by 'a' - 'A'.
     * Just remember in ASCII table, upper case comes before lower case
     * @param input
     * @return upper cased string
     */
    public static String convertLowerToUpper(String input){
        int delta = 'a' - 'A';
        System.out.println("The delta is " + delta);
        char[] arr = input.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 'Z'){
                //means its lower case
                arr[i] = (char) (arr[i] - delta);
            }
        }
        return new String(arr);
    }

    /**
     * Switch lower to upper and upper to lower. Again, we will use the ASCII table
     * for this logic.
     * Note that this does not handle numbers in the string.
     * (We can handle that by adding a private method called isNumber which checks if c <= '9' && c >= '0'.
     * @param input The input string
     * @return string with swapped cases
     */
    public static String switchCases(String input){
        char[] array = input.toCharArray();
        //now we iterate and see if the char is upper or lower.
        //convert lower to upper by subtracting delta, convert upper to lower by adding delta
        int delta = 'a' - 'A';
        for(int i=0;i<array.length;i++){
            if(array[i] > 'Z'){
                //its lower case so we need to make it upper case by subtracting delta
                array[i] = (char)(array[i] - delta);
            }else{
                //its upper case
                array[i] = (char)(array[i] + delta);
            }
        }
        return new String(array);
    }


    /**
     * A function that checks if a string is a number, and returns that number.
     * This will return 0 if the string is not a number.
     * Test cases -
     * "-123" ==> -123
     * "+123" ==> 123
     * "123" ==> 123
     * "-123-" ==> 0
     * Since we are dealing with integers, there is no need to handle decimals.
     * We can write another revision of this code to handle a floating point.
     *
     * @param string The input string
     * @return null if not a number, numeric value if it is a number.
     */
    public static int getNumericValue(String string){
        //first off the sign has to be there, if at all, at the first place.
        //if so, store it.
        char[] array = string.toCharArray();
        boolean isSign = array[0]=='-' || array[0]=='+';
        //we need to return the negative int if thats the case
        int signValue = (array[0]=='-')? -1:1;
        //now we start looking up the values in the char[].
        //if there is a sign, we skip index 0. If not, we start with index 0
        int start = 0;
        if(isSign) start = 1;
        int value = 0;
        for(int i=start;i<string.length();i++){
            if(!(array[i] >= '0' && array[i] <='9')) {
                return 0;
            }else{
                //since we're creating a number we need to build it given the unit values
                //Every iteration basically multiplies the number by 10
                value = value*10 + array[i] - '0';
            }
        }
        return value * signValue;
    }

    /**
     * Remove all characters of first from second, and clean up 2nd to return a new string
     * @param first The first string
     * @param second The second string
     * @return A cleaned up 2nd string
     */
    public static String cleanSecondString(String first, String second){
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        //loop through first and remove all elements in 2nd that match that character
        //Freakin N*N worst case complexity here.
        for(int i=0;i<firstArray.length;i++){
            for(int j=0;j<secondArray.length;j++){
                if(secondArray[j] == firstArray[i]) secondArray[j] = '\n'; //lets just add a newline and later we will get rid of all newlines
            }
        }
        //now we have the 2nd array with a bunch of new lines for the matches, we create a new array removing all the newlines
        //how long is the new array? that'd be the size minus the newlines
        int newLineCount = 0;
        //Add N to the complexity
        for(char c: secondArray){
            if(c == '\n') ++newLineCount;
        }
        char[] newArray = new char[secondArray.length-newLineCount];

        int newArrayIndex = 0;
        //Add another N to the complexity
        for(char c:secondArray){
            if(c !='\n') {
                newArray[newArrayIndex] = c;
                ++newArrayIndex;
            }
        }
        //Total complexity is N*N + 2N or basically N*N. Terrible impl.
        return new String(newArray);
    }
}
