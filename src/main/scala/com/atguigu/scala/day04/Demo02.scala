package com.atguigu.scala.day04

import scala.collection.JavaConversions.bufferAsJavaList
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
//import scala.collection.mutable
//import scala.collection.mutable._

object Demo02 {
  def main(args: Array[String]): Unit = {
    var scalaArr: ArrayBuffer[String] = ArrayBuffer("a", "b", "c", "d")
    //val array = scalaArr :+ "d"
    //scalaArr.foreach(x => print(x))
    scalaArr.foreach(print(_))
    println("\n")
    println(scalaArr.tail)
    //scala
    var javaArr: java.util.List[String] = scalaArr

    ////////////////////////////Map//////////////////////////////////
    var m1: Map[String, Int] = Map(("a", 1))
    val map1 = Map("a" -> 2, "b" -> 3, "c" -> 4)
    for (ele <- map1) {
      print(ele._1)
      println(ele._2)
    }

    var map2 = mutable.Map("A" -> 1, "B" -> 2, "C" -> 3)
    println(map2.keySet)
    map2.getOrElseUpdate("D", 4)
    for ((k, v) <- map2) {
      print(k)
      println(v)
    }


    //////////////////////////////SET///////////////////////
    val set1 = Set(1, 2, 3, 4, 5, 6)
    val set = set1 + 7
    println(set1)
    println(set)

    var set2 = mutable.Set(6, 3, 2, 8)
  }
}
