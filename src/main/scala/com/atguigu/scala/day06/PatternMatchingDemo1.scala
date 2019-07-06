package com.atguigu.scala.day06

import scala.io.StdIn

//PatternMatchingDemo1这是1个独立对象 stand-alone object ，它和任何类都没有自动的关联
object PatternMatchingDemo1 {
  def main(args: Array[String]): Unit = {
    var a = 5
    var b = 3
    println(a)
    println(b)
    println("请输入操作符（+、-、*、/）:")
    var opr = StdIn.readLine()
    val result = opr match {
      case "+" => a + b
      case "-" => a - b
      case "*" => a * b
      case "/" => a / b
      case _ => "请输入（+、-、*、/）"
    }
    println(result)
    println("==============华丽丽的分割线==============")

    //-------------------------------------
    for (ch <- "+-3&%") {
      var digit = 0
      val sign = ch match {
        case '+' => '+'
        case '-' => '-'
        //守卫可以是任何布尔条件
        case _ if Character.isDigit(ch) => {
          digit = Character.digit(ch, 10);
          digit
        }
        case _ => 0
      }
      println(ch)
      println(sign)
      println(digit)
      println("============================")
    }

    var ch = 0
    try {
      'z' match {
        case 'a' => println("a...........")
        case 'b' => println("b...........")
        case 'c' => println("c...........")
        case ch => println("...........ch=" + ch)
      }
    } catch {
      case ex: NullPointerException =>
      case ex: ClassCastException =>
      case ex: Exception =>
    }

    var obj: Any = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val result1 = obj match {
      case a: Int => println(a)
      case b: Map[String, Int] => println(b)
      case _ => println("Nothing is matched...")
    }
    println(result1)
  }
}
