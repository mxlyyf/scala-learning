package com.atguigu.scala.day05

import scala.io.Source

object GroupByDemo {

  def main(args: Array[String]): Unit = {
    var list = List(1,2,3,4,5,6,7,8,9,10,11)
    val even = list.filter( x => x % 2 ==0)
    println(even)
    //groupby
    val map : Map[String, List[Int]] = list.groupBy(x => if (x%2==0) "even" else "odd")
    println(map)
    println(map.map(kv => (kv._1, kv._2.size)))

    //wordcount
    var list1 = List("hello at guigu","shi jie na me da","na me da","wo want \t to see see")
    var list2 = Source.fromFile("D:\\IdeaProjects\\scala\\src\\main\\scala\\com\\atguigu\\scala\\day05\\GroupByDemo.scala").getLines()

    val words = list2.flatMap(line => line.split("\\W+")).toList
    println(words)
    println(words.groupBy(s => s).map(kv => (kv._1, kv._2.length)))
  }

}
