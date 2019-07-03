package com.atguigu.scala.day05

object FoldDemo {
  def main(args: Array[String]): Unit = {
    var list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    //sum
    println(list.foldLeft(0)((x, y) => x + y))
    //min
    println(list.foldLeft(Int.MaxValue)((x, y) => x.min(y)))
    list./:(Int.MaxValue)((x, y) => x.min(y))
    (Int.MaxValue /: list) ((x, y) => x.min(y))///   /:foldLeft
    //max
    println(list.foldLeft(Int.MinValue)((x, y) => x.max(y)))

    //一次性求出sum,max,min
    println(list.foldLeft((0, Int.MinValue, Int.MaxValue))((z, x) => (z._1 + x, z._2.max(x), z._3.min(x))))
  }
}
