package com.manish.interview;


/**
 * This class has number-related questions.
 * Not necessarily using a lot of data structures.
 * Created by mpandit on 1/25/15.
 */
public class NumberQuestions {


    public static void main(String[] args){
        getFibonacchiSeries(20);
        System.out.println(multiplyByTwo(-5));
        System.out.println(divideByTwo(-10));
        System.out.println(divideByFour(-12));

    }

    /**
     * Get fibonachhi series up to the count
     * @param count the number of elements in the series
     * @return the series
     */
    public static void getFibonacchiSeries(int count){
        for(int i=0;i<count;i++){
            System.out.println(getFibonacchiNumberAt(i));
        }
    }

    public static int getFibonacchiNumberAt(int n){
        if(n <=2 ) return 1;
        else return getFibonacchiNumberAt(n - 1) +getFibonacchiNumberAt(n - 2);
    }

    /**
     * Using bitshift operator, multiply a number by 2.
     * We use left shift here, and the result wont matter for signed ints.
     * The arithmatic and logical shift have same result.
     *
     * @param n The number
     * @return 2n
     */
    public static int multiplyByTwo(int n){
        return n << 1;
    }

    /**
     * Divide the number by 2 using bitshifts.
     * Be careful with the signs here.
     * The logical operator >>> will fill the sign bit with 0 and the LSB will be same as LSB-1
     * The arithmatic operator will retain the sign so the result will be same for +ve or -ve numbers.
     * Printing out the results for both for clarification.
     * @param n The number
     * @return n/2
     */
    public static int divideByTwo(int n){
        System.out.println("The arithmathic shift is  " +( n >> 1));
        System.out.println("The logical shift is " + (n >>> 1));
        return n >> 1; // we return the arithmatic shift
    }

    /**
     * Divide by 4 by right shifting by 2 bits
     * @param n The number
     * @return n/4
     */
    public static int divideByFour(int n){
        return n >> 2;
    }


    /**
     * Without using any loops check if the number is a power of two
     * @param n The number
     * @return if the number if a power of 2 or not
     */
    public static boolean isPowerOfTwo(int n){
       return false;
    }
}
