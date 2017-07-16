package com.spark.demistify.utility

import org.apache.log4j.{Level, Logger}
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by eujjsat on 7/16/2017.
  */
object MapPartitionFunction {
  /**
    * This function describes the usecases of rdd MapPartition fn.
    * @param args
    */
  def main(args: Array[String]) = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val listRdd = sc.parallelize(List(10, 22, 53, 24, 15, 60, 27, 78, 39,31))
    val partitionedListRdd = listRdd.mapPartitionsWithIndex(filterPartition) //Show rdd elements gt 40 along with their partition id.
  }

  /*This fn is called in each of the rdd partitions and filter out the value gt 40.*/
  def filterPartition(index: Int,iter: Iterator[Int]) : Iterator[String] = {
    iter.filter(x => x > 40).map(x => x+ "#" + index)
  }
}

