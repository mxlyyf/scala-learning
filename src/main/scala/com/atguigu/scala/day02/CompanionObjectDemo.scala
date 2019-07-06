package com.atguigu.scala.day02

import scala.collection.mutable

object CompanionObjectDemo {
  def main(args: Array[String]): Unit = {
    val maker = Maker.getMaker("green")
    //println(maker)
    println(Maker.suppliedColors)

    //val maker2 = Maker("yellow")
    val maker3 = Maker("myname","mycolor")
    println(maker3.name)
  }

}

object Maker {
  private var makers = mutable.Map("red" -> new Maker("red"), "blue" -> new Maker("blue"),
    "yellow" -> new Maker("yellow"))

  def getMaker(color: String): Maker = {
    makers.getOrElseUpdate(color, new Maker(color))
  }

  val suppliedColors: Iterable[String] = makers.keys

  def apply(color: String): Maker = getMaker(color)

  def apply(name: String,color:String): Maker = new Maker(name,color)
}

class Maker private(var color: String) {
  override def toString: String = s"Maker color: $color"
  var name: String = _

  def this(){
    this("color")
    println("辅助构造函数")
  }

  def this(name: String,color:String){
    this
    this.name = name
    this.color = color
  }
  //def apply(color: String): Maker = new Maker(color)

}
