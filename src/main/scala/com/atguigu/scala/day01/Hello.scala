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

    val map = Map("Tom"-> 23)
    //map("Jack") // 抛出异常 java.util.NoSuchElementException: key not found: Jack
    map.get("Jack") // None
    println(map("Tom")) // 23
    map.get("Tom") // Some(23)

    val option = map.get("tom")

    val age: Int = option match {
      case Some(x) => option.get
      case None => 0
    }
    println(age)
  }

}
