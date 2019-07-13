package com.atguigu.spark.streaming.transform

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

//updateStateByKey
object Demo1 {
  def main(args: Array[String]): Unit = {
    val conf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("StreamingDemo1")
    val ssc: StreamingContext = new StreamingContext(conf, Seconds(5))

    val dStream: ReceiverInputDStream[String] = ssc.socketTextStream("hadoop101", 9999)

    val dstream1: DStream[(String, Int)] = dStream.flatMap(_.split("\\W+")).map((_,1))

    val ds: DStream[(String, Int)] = dstream1.updateStateByKey[Int]((seq: Seq[Int], option: Option[Int]) => {
      Some(seq.sum + option.getOrElse(0))
    })
    ds.print()

    ssc.checkpoint("./checkpoint")
    ssc.start()
    ssc.awaitTermination()
  }
}
