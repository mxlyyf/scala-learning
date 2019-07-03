package com.atguigu.scala.day06

object MyWhileDemo {
  def main(args: Array[String]): Unit = {
    var i = 0
    mywhile (i<10){
      print(i + "\t")
      i += 1
    }
  }

  def mywhile(condition: => Boolean)(action : => Unit): Unit ={
    if (condition){
      action
      mywhile(condition)(action)
    }
  }
}
