package com.atguigu.spark.udf

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, DoubleType, LongType, StringType, StructField, StructType}

import scala.collection.immutable.Nil

class MyUDAF extends UserDefinedAggregateFunction {
  override def inputSchema: StructType = {
    StructType(StructField("inputColumn", DoubleType) :: Nil)
  }

  override def bufferSchema: StructType = {
    StructType(StructField("count", LongType) :: StructField("sum", DoubleType) :: Nil)
  }

  //数量：...，总和：...，平均值：...
  override def dataType: DataType = StringType

  override def deterministic: Boolean = true

  override def initialize(buffer: MutableAggregationBuffer): Unit = {
    buffer(0) = 0L //数量
    buffer(1) = 0d //总和
  }

  override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
    if (!input.isNullAt(0)) {
      buffer(0) = buffer.getLong(0) + 1L
      buffer(1) = buffer.getDouble(1) + input.getDouble(0)
    }
  }

  override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
    buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
    buffer1(1) = buffer1.getDouble(1) + buffer2.getDouble(1)
  }

  override def evaluate(buffer: Row): String = {
    f"数量：${buffer(0)}，总和：${buffer(1)}，平均值：${(buffer.getDouble(1) / buffer.getLong(0)) % 2d}"
  }
}

case class Emp(name: String, salary: Double)

object MyUDAF {
  def main(args: Array[String]): Unit = {
    val spark: SparkSession = SparkSession.builder()
      .master("local[*]")
      .appName("MyUDAF")
      .getOrCreate()

    import spark.implicits._

    //API方式：rdd转df
    val rdd = spark.sparkContext.parallelize(Seq("zs,145.22", "ls,145.84", "ww,188.09", "zl,190.00"))
    val rowRdd = rdd.map(s => {
      val para = s.split(",")
      Row(para(0), para(1).toDouble)
    })
    val structType: StructType = StructType(StructField("name", StringType) :: StructField("salary", DoubleType)  :: Nil)
    val df1 = spark.createDataFrame(rowRdd,structType)
    df1.show()

    //自定义udaf
    val seq = Seq(("zs", 145.22), ("ls", 145.84), ("ww", 188.09), ("zl", 190.00), ("zs", 145.29), ("zs", 177.77))
    val df = seq.toDF("name", "salary")
    spark.udf.register("myUDAF", new MyUDAF)
    df.createOrReplaceTempView("emp")
    spark.sql(
      """
        |select myUDAF(salary) as remark
        |from
        |emp
        |group by name
      """.stripMargin).show()
  }
}
