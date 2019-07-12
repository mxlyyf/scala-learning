package com.atguigu.spark

import org.apache.spark.{SparkConf, SparkContext}

object WordCount {
  def main(args: Array[String]): Unit = {
    var conf: SparkConf = new SparkConf().setAppName("WordCount")
    //conf.setMaster("local[*]")
    var sc: SparkContext = new SparkContext(conf)
    //sc.textFile("D:\\Documents\\mrinput\\wordcount")
    sc.textFile("/mrinput/wordcount")
      .flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_ + _)
      //.saveAsTextFile("D:\\Documents\\mroutput\\wordcount")
      .saveAsTextFile("/mroutput/wordcount")
    //关闭连接
    sc.stop()
  }
}
