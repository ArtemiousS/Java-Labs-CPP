/**
  * Scala first lab
  * there are 2 algorithms, which realize with ana without tail-recursion
  * @author Colonel_Dzik
  * @version 2.0
  */

import scala.annotation.tailrec
import scala.collection.immutable.List

object largeWord{
  /**
    * main method
    * @param args
    */
   def main(args: Array[String]) = {
    val words=List("fjhgjr", "gfd", "fgse")
    println(largest(words))
     println(largest2(words, "\0"))
     prime(List(3,5,7,10))
     prime2(List(3,5,7,10), 0)
  }

  /**
    * function which find the longest word in the List
    * @param words
    * @return word
    */
    def largest(words: List[String]) = {
      words.reduce(
        (a, b) =>
          if (a.length < b.length)
            b
          else
            a
      )
    }

  /**
    * this is the same function with tail-recursion
    * @param words
    * @param theMax
    * @return longest word
    */
      @tailrec
      def largest2(words: List[String], theMax: String): String = {
        if (words.isEmpty) {
          return theMax
        } else {
          val newMax = if (words.head.length > theMax.length) words.head else theMax
          largest2(words.tail, newMax)
        }
      }

  /**
    * function which check number is primeor not
    * @param n
    * @return bool
    */
  def isPrime(n: Int) ={
    List.range(2, n) forall (x => n % x != 0)
  }

  /**
    * simple function which check, what numbers are prime
    * @param numbers
    */
  def prime(numbers:List[Int])=
    {
      numbers foreach(x=>if(isPrime(x)==true)println(x))
   }

  /**
    * the same function but with tailrec
    * @param numbers
    * @param prime
    */
  @tailrec


}


