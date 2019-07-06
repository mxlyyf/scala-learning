package com.atguigu.scala.day01

object StringDemo {
  def main(args: Array[String]): Unit = {
    var s =
      """This is a
        |multi 'multiply',"subliply"
        |string.
      """.stripMargin
      println(s)

    "Hello world".split("\\W+").foreach(println)

    var f = 300
    println(f"weight $f%.2f")
  }

}
