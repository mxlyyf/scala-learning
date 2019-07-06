package com.atguigu.scala.day07

class PartialFunctionDemo1[A, B](a: A, b: B) {
  def foo(): B = {
    println(a, b)
    b
  }

  def foo[T](t: T): T = {
    t
  }
}

object PartialFunctionDemo1 {
  def main(args: Array[String]): Unit = {
    var p = new PartialFunctionDemo1(3, "abc")
    p.foo()
    println(p.foo("acd"))

    //var list = List(1, 3, 5, "seven")
    //list map  { case i: Int => i + 1 }
    //List(1, 3, 5, "seven") collect { case i: Int => i + 1 }
    //println(list.collect({ case int: Int => int + 1 }))
    //偏函数，这是个trait
    val inc = new PartialFunction[Any, Int] {
      //def apply(any: Any) = any.asInstanceOf[Int] + 1
      //def isDefinedAt(any: Any) = if (any.isInstanceOf[Int]) true else false
      override def isDefinedAt(x: Any): Boolean = if (x.isInstanceOf[Int]) true else false //用来告知调用方这个偏函数接受参数的范围，可以是类型也可以是值
      override def apply(v1: Any): Int = v1.asInstanceOf[Int] + 1 //用来描述对已接受的值如何处理
    }
    println(List(1, 3, 5, "seven") collect inc)

    //结合case语句定义一个偏函数，当然，如果偏函数的逻辑非常复杂，可能通过定义一个专门的类并继承PartialFunction是更好选择。
    def inc2: PartialFunction[Any, Int] = {
      case int: Int => int + 1
    }
    println(List(1, 3, 5, "seven") collect inc2)
    val inc3: PartialFunction[Any, Int] = {
      case int: Int => int + 1
    }
    println(List(1, 3, 5, "seven") collect inc3)

    val second: PartialFunction[List[Int],Int] = {
      case x :: y :: _ => y
    }
    //Function类型有多个版本，Function0表示无参数函数，Function1表示只有一个参数的函数，以此类推。至此我们解释的是一个普遍性问题：是函数就是对象，是对象就有类型。


  }

}
