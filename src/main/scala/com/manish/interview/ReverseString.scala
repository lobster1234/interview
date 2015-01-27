package com.manish.interview

/**
 * Created by mpandit on 1/26/15.
 * Reverse a string using recursion
 */
object ReverseString extends App{

  println(s"""Reverse of reverse is  ${reverseString("reverse")}""")

  def reverseString(string : String) : String = {
    if(string.length <= 1) string
    else string.substring(string.length-1,string.length) + reverseString(string.substring(0,string.length-1))
  }

}
