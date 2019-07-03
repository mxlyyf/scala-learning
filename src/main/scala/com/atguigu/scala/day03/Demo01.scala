package com.atguigu.scala.day03

import java.io.File
import java.time.LocalDate

import scala.io.Source

object Demo01 {
  //implicit def file2RichFile(file : File) : RichFile = new RichFile(file)
  //implicit def date2RichDate(int : Int) : RichDate = new RichDate(int)

  def main(args: Array[String]): Unit = {
    var file : File = new File("D:\\Documents\\edits.xml")
    println(file.readContext)

    val ago : String = "ago"
    val later : String = "later"
    println(5 days ago)
    println(5 days later)

  }

  implicit class RichDate(int : Int) {
    def days(p : String): String = {
      if (p == "ago") {
        LocalDate.now().minusDays(int).toString
      } else {
        LocalDate.now().plusDays(int).toString
      }
    }
  }

  implicit class RichFile(file: File) {
    def readContext ={
      Source.fromFile(file).mkString
    }
  }
}




