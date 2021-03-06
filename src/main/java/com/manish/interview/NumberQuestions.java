package com.manish.interview;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class has number-related questions.
 * Not necessarily using a lot of data structures.
 * Created by mpandit on 1/25/15.
 */
public class NumberQuestions {


    public static void main(String[] args) throws Exception{
        getFibonacchiSeries(20);
        System.out.println(multiplyByTwo(-5));
        System.out.println(divideByTwo(-10));
        System.out.println(divideByFour(-12));
        System.out.println("Is 32 a power of 2 ? " + isPowerOfTwo(32));
        System.out.println("Is 31 a power of 2 ? " + isPowerOfTwo(31));
        for(int i=0;i<10;i++){
            System.out.println("Factorial of " + i + " is " + getFactorial(i));
        }
        SimpleDateFormat fmt = new SimpleDateFormat("MM/dd/yyyy");

        System.out.println("Difference in 2 dates is " + getDaysBetweenDates(fmt.parse("01/01/2014"), fmt.parse("12/31/2014")));
        System.out.println("Months between the 2 dates are " + getMonthsBetweenDates(fmt.parse("01/01/2014"), fmt.parse("12/31/2014")));

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
       //Here we use this algorithm that I found on Wikipedia.
       //A number is a power of 2 if N & (N-1) = 0
        return (n & (n-1)) == 0;
    }

    /**
     * Get factorial of a given number
     * @param n the number
     * @return factorial of the given number
     */
    public static int getFactorial(int n){
        if(n == 1) return 1;
        if(n == 0) return 0;
        else return n*getFactorial(n-1);
    }


    /**
     * Find the number of days between 2 dates
     * @param start Date1
     * @param end Date2
     * @return number of days between start and end dates
     */
    public static long getDaysBetweenDates(Date start, Date end){
        //Simple enough, we need to know how many milliseconds are in a day
        long millisecondsInADay = 24*60*60*1000;
        long difference = end.getTime() - start.getTime();
        return difference/millisecondsInADay;
    }

    /**
     * Find the number of months between 2 dates
     * @param start Start date
     * @param end End date
     * @return The number of months between start and end dates.
     */
    public static long getMonthsBetweenDates(Date start, Date end){
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(start);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(end);
        long months = 0;
        while(calEnd.after(calStart)){
            calStart.add(Calendar.MONTH,1);
            ++months;
        }
        return months;
    }
}
