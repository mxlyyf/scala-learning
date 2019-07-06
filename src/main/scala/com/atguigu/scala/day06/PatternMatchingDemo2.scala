package com.atguigu.scala.day06

object PatternMatchingDemo2 {
  def main(args: Array[String]): Unit = {
    val arr = Array(1, 2, 3, 4)
    println(arr.toList)
    //匹配数组
    val result = arr match {
      case Array(0) => "Array(0)"
      case Array(1, 2) => "Array(0,1)"
      //case Array(_, _, _, 4) => "array(_,_,_,4)"
      case Array(_*) => "any array"
      case _ =>
    }
    println(result)

    //匹配元组
    var t1 = (1, "a", true)
    val res = t1 match {
      case (c, a, b) => c + a + b
      case _ =>
    }
    println(res)
  }
}
