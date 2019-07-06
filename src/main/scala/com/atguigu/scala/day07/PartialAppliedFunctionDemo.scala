package com.atguigu.scala.day07

object PartialAppliedFunctionDemo {
  def main(args: Array[String]): Unit = {
    println(addX(2, 3))
    println(normalMul(2, 3))
    println(mul(2)(3))
    val f = foo(1, _: Int, _: Int)
    println(f(6, 9))
  }

  def add(x: Int, y: Int, z: Int) = x + y + z

  def addX = add(1, _: Int, _: Int) // x 已知

  // 正常写法
  def normalMul(x: Int, y: Int) = x * y

  // 函数柯里化
  def mul(x: Int): Int => Int = {
    y => x * y
  }

  // 柯里化简写
  def mul2(x: Int)(y: Int): Int = x * y

  def foo(a: Int, b: Int, c: Int) = {
    a + b + c
  }

  def foo1(a: Int, b: Int) = {

  }
}
