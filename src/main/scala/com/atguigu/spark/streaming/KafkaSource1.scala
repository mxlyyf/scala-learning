package com.atguigu.spark.streaming

import kafka.serializer.StringDecoder
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka.KafkaUtils

/**
  * 方式一、bug：宕机无法消费之前的数据，只能从最新的offset消费
  */
object KafkaSource1 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("KafkaSource1")
    val ssc = new StreamingContext(conf, Seconds(3))
    val brokers = "hadoop101:9092,hadoop102:9092,hadoop103:9092"
    val topic = "topic1"
    val group = "bigdata"
    val para: Map[String, String] = Map(
      ConsumerConfig.GROUP_ID_CONFIG -> group,
      ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokers
    )

    val dStream: InputDStream[(String, String)] = KafkaUtils.createDirectStream[String, String, StringDecoder, StringDecoder](ssc, para, Set(topic))

    dStream.print

    val wc: DStream[(String, Int)] = dStream.map(_._2).flatMap(_.split("\\W+")).map((_, 1)).reduceByKey(_ + _)
    wc.print

    ssc.start()
    ssc.awaitTermination()
  }
}
