package com.atguigu.scala.day05

object ZipDemo01 {
  def main(args: Array[String]): Unit = {
    var list1: List[Int] = List(1, 2, 3, 4, 5, 6)
    var list2: List[Int] = List(1, 2, 3, 4, 5)
    val tuple1 = list1.zip(list2)
    println(tuple1)

    val tuple2 = list1.zipAll(list2,-1,-2)
    println(tuple2)

    val index = list1.zipWithIndex//与元素下标
    println(index)

    var ch = 0
    'z' match {
      case 'a' => println("a...")
      case 'b' => println("b...")
      case 'c' => println("c...")
      case ch => println("变量 ch = " + ch)
    }

    val sample = new Sample
    sample.process(1000)
  }
}

class Sample {
  val max = 1000
  def process(input: Int): Unit = {

    input match {
      case `max` => println(s"You matched max")
    }
  }
}
