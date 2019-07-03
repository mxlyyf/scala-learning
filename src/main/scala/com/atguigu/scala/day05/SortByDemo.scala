package com.atguigu.scala.day05

object SortByDemo {
  def main(args: Array[String]): Unit = {

    val list: List[Int] = List(2, 5, 7, 9, 1, 3, 4)
    println(list.sortBy(x => x)(Ordering.Int.reverse))
    println(list.sortBy(x => x)(Ordering.Int))

    val list2 = List("shi", "jie", "na", "me", "da", "wo", "xiang", "qu", "kan", "kan")
    println(list2.sortBy(s => s)) //按照String排序

    val list3 = List(new Student("a", 20), new Student("c", 25),
      new Student("b", 25), new Student("b", 23))

    //按照student的name，age排序，name相同按照age排
    val students = list3.sortBy(student => (student.name, student.age))(Ordering.Tuple2(Ordering.String.reverse, Ordering.Int))
    println(students)

  }
}

class Student(val name: String, val age: Int) {
  override def toString: String = s"Student($name , $age)"
}
