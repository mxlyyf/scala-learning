package com.atguigu.scala.day04

import scala.collection.mutable

object Demo03 {
  def main(args: Array[String]): Unit = {
    val list = List(3, 2, 1)
    val list1 = list.map(_ * 2)
    println(list1)
    val names = List("Alice", "Bob", "Nick")
    //map
    println(names.map(name => name.toUpperCase))
    //flatMap
    println(names.flatMap(s => s.toUpperCase))
    //filter
    val list2 = mutable.ListBuffer(1, 2, 3, "c", 4, "a", "b", 5, 7)
    val listBuffer = list2.filter(x => x.isInstanceOf[Int])
    println(listBuffer)
    //reduce
    val list3: List[Int] = List(1, 2, 3, 4, 5, 6, 7)
    val sum = list3.reduce((x, y) => x + y)
    println(s"sum : $sum")
    val min = list3.reduce((x, y) => {
      if (x < y) x else y
    })
    println(s"min : $min")
    val max = list3.reduce((x, y) => {
      if (x > y) x else y
    })
    println(s"max : $max")
    //fold,提供1个初始值，可以把reduce看作是fold的初始值
    var list4 = List(10, 1, 3, 5, 8, 9, 22, 89)
    val i = list4.fold(0)((x,y) => x + y)
    println(i)

    ////
    val list5 = List(1, 2, 3, 4, "abc")
    println(list5.filter(ele => ele.isInstanceOf[Int]).map(x => x.asInstanceOf[Int]).map(_ + 1))
  }

}
