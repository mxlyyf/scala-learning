package com.atguigu.spark.jdbc

import org.apache.spark.sql.{SaveMode, SparkSession}

object jdbcDemo {
  def main(args: Array[String]): Unit = {
    //1.写数据到mysql
    val spark: SparkSession = SparkSession.builder().master("local[*]").appName("jdbcDemo").getOrCreate()
    import spark.implicits._

    val seq = Seq(("zs", 145.22), ("ls", 145.84), ("ww", 188.09), ("zl", 190.00), ("zs", 145.29), ("zs", 177.77))
    val df = seq.toDF("name", "salary")

    df.write.format("jdbc")
      .option("url", "jdbc:mysql://192.168.213.101:3306/test")
      .option("user", "root")
      .option("password", "123456")
      .option("dbtable", "student")
      .mode(SaveMode.Append)
      .save()
  }

}
