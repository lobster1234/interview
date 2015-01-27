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

}
