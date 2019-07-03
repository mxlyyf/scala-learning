package com.atguigu.scala.day01

object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello world!!!")


    var a: Int = 2
    var b: Int = 3

    //在scala中没有真正的运算符，只有方法调用
    var c = a.+(b)


    //在scala中，任何的有语法结构都有值
    val arr = for (i <- 1 to 10){
      i * i
    }

  }

}
