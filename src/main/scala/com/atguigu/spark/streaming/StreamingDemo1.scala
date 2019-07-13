package com.atguigu.spark.streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamingDemo1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamingDemo1")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))
    val wc = ssc.socketTextStream("hadoop101", 9999).flatMap(_.split("""\s+""")).map((_, 1)).reduceByKey(_ + _)
    wc.print
    //开始接受数据并计算
    ssc.start()
    //等待计算结束(要么手动退出,要么出现异常)才退出主程序
    ssc.awaitTermination()
  }
}
