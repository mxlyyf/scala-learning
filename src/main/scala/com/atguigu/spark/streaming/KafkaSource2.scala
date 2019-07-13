package com.atguigu.spark.streaming

import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
  * 方式二、kafka高阶API，offset持久化到checkpoint上
  */
object KafkaSource2 {
  def main(args: Array[String]): Unit = {
    val ssc: StreamingContext = StreamingContext.getActiveOrCreate("./checkpoint", createSsc _)
    ssc.checkpoint("./checkpoint")
    ssc.start()
    ssc.awaitTermination()
  }

  def createSsc: StreamingContext = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("KafkaSource2")
    val ssc = new StreamingContext(conf, Seconds(5))

    val brokers = "hadoop101:9092,hadoop102:9092,hadoop103:9092"
    val topic = "topic1"
    val group = "bigdata"
    val para: Map[String, String] = Map(
      ConsumerConfig.GROUP_ID_CONFIG -> group,
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers
    )

    val dStream: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, para, Set(topic))
    dStream.print

    val wordcount: DStream[(String, Int)] = dStream.map(_._2).flatMap(_.split("\\W+")).map((_, 1)).reduceByKey(_ + _)
    wordcount.print

    ssc
  }
}
