package com.atguigu.spark.accu

import org.apache.spark.rdd.RDD
import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

object AccuDemo1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("AccuDemo1")
    val sc: SparkContext = new SparkContext(conf)

    val rdd: RDD[Int] = sc.parallelize(1 to 5,2)

    //var sum_accu = sc.longAccumulator("sum")
    val accu: CustomerAccumulator = new CustomerAccumulator

    sc.register(accu)

    val rdd2: RDD[(Int, Int)] = rdd.map(x => {
      accu.add(x)
      (x, 1)
    })

    rdd2.foreach(println)

    println(accu.value)
  }
}
