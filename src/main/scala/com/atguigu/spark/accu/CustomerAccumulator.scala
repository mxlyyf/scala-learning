package com.atguigu.spark.accu

import org.apache.spark.util.AccumulatorV2

class CustomerAccumulator extends AccumulatorV2[Long, Long] {
  private var sum: Long = 0L

  override def isZero: Boolean = sum == 0L

  override def copy(): AccumulatorV2[Long, Long] = {
    val accu = new CustomerAccumulator
    this.sum = accu.sum
    accu
  }

  override def reset(): Unit = sum = 0L

  override def add(v: Long): Unit = sum += v

  override def merge(other: AccumulatorV2[Long, Long]): Unit = this.sum += other.value

  override def value: Long = this.sum
}

object CustomerAccumulator {
  def apply: CustomerAccumulator = new CustomerAccumulator()
}