package com.manish.interview

/**
 * Created by mpandit on 1/26/15.
 * String questions..
 */
object StringQuestionsS extends App{

  println(s"""Reverse of reverse is  ${reverseStringRecursive("reverse")}""")

  def reverseStringRecursive(string : String) : String = {
    if(string.length <= 1) string
    else string.substring(string.length-1,string.length) + reverseStringRecursive(string.substring(0,string.length-1))
  }

}
