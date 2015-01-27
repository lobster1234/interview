package com.manish.interview

/**
 * General number questions - not a whole lot of data structures here.
 *
 */
object NumberQuestionsS extends App{

  println("First 10 fibonacci numbers are ")
  for(i<-1 to 10){
      println(fib(i))
  }

  def fib(n:Int) : Int = {
    if(n <= 2) 1
    else fib(n-2) + fib(n-1)
  }



}
