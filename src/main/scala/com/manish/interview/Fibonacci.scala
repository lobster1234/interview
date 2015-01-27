package com.manish.interview

/**
 * Generate fibonacci series up to N numbers.
 * Created by mpandit on 1/26/15.
 */
object Fibonacci extends App{

  println("Fibonacchi series up to 10 numbers is")
  for(i<-1 to 10){
    println(fib(i))
  }

  def fib(n:Int) : Int = {
    if(n<=2) 1 else fib(n-2) + fib(n-1)
  }

}
