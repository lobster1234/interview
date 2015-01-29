package com.manish.interview;

/**
 * Created by mpandit
 *
 */
public class SearchSortQuestions {

    public static void main(String[] args){
        int[] sortedArray = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(sortedArray, 7));
    }


    /**
     * Search an int in a sorted array of ints. We are assuming the input is sorted.
     * The complexity is logN (base 2)
     * @param data The sorted int array
     * @param value The value to search
     * @return true or false depending on if the value was found
     */
    public static boolean binarySearch(int[] data, int value){
        //first check if the value is within our range
        if(value < data[0] || value > data[data.length-1]) return false;
        int left = 0;
        int right = data.length-1;
        //we split the array into two and search the 1st half
        while(left < right){
            //now we take the mid point
            //check the mid point too
            int mid = (left + right)/2;
            //first we get a simple check out of the way
            if(data[left] == value || data[right] == value || data[mid] == value) return true;
            //is the value between the start and end index?
            if(value < data[mid]){
                //we have the right section, now we check between the left and mid
                right = mid+1;
            }else{
                //else we make the mid as left
                left = mid-1;
            }
        }
        return false;

    }
}
