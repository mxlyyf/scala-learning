package com.atguigu.scala.day06

object PatternMatchingDemo3 {
  //def apply: PatternMatchingDemo3 = new PatternMatchingDemo3()
  def main(args: Array[String]): Unit = {
    var arr = Array(Dollar(1000), Current(10000, "RMB"))

    for (ele <- arr) {
      val str = ele match {
        case amout: Dollar => "$" + amout.value
        case amout: Current => amout.unit + amout.value
        case _ => ""
      }
      println(str)
    }

    val list = List(1, 2, 3, 4)
    val res = list match {
      // one 会匹配第一个元素, two 会匹配第二个元素, rest 匹配剩下的所有元素
      case a :: b :: rest => s"a = $a, b = $b, rest = $rest"
      case _ => "没有任何的匹配"
    }
    println(res)
  }
}

abstract class Amount

case class Dollar(value: Double) extends Amount

case class Current(value: Double, unit: String) extends Amount
