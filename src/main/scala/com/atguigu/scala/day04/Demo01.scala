package com.atguigu.scala.day04

object Demo01 {
  def main(args: Array[String]): Unit = {
    var t1: (Int, String, Boolean, Int) = (2, "a", true, 4)
    for (ele <- t1.productIterator) {
      println(ele)
    }
    println(t1._2)

    var l1: List[Int] = List(1, 2, 3, 4)
    var l2: List[Int] = 1 :: 2 :: 3 :: 4 :: 5 :: Nil
    println(l1)
    println(l2)
    println(l1 :+ 6 :+ 7)

    val a: Double = 1
  }
}
