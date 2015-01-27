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

  for(i <-0 to 10){
    println(s"""Factorial of $i is ${factorial(i)}""")
  }

  def fib(n:Int) : Int = {
    if(n <= 2) 1
    else fib(n-2) + fib(n-1)
  }


  def factorial(n:Int) : Int = {
    if(n == 1) 1 else if (n==0) 0 else n*factorial(n-1)
  }

}
