package com.atguigu.scala.day05

import scala.collection.mutable
import scala.collection.mutable.{ArrayBuffer, ListBuffer}

object Demo01 {

  def main(args: Array[String]): Unit = {
    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"

    var arr1: ArrayBuffer[Char] = new ArrayBuffer[Char]()

    sentence.foldLeft(arr1)((arr, c) => {
      arr1.append(c)
      arr1
    })
    println(arr1)

    var list = List("hello","atguigu","meilaica")
    val chars = list.flatMap(s => s.concat("a"))
    println(chars)

    var map : mutable.Map[Char,Long] = mutable.Map()

    sentence.foldLeft(map)((map,c) => {
      map += c -> (map.getOrElseUpdate(c,0)+1)
    })
    println(map)
  }

}
