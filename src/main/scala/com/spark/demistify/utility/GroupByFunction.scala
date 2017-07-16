package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by eujjsat on 7/16/2017.
  */
object GroupByFunction {
  /**
    * This function describes the usecases of rdd groupBy fn.
    * @param args
    */
  def main(args: Array[String]) = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val pairList = List("spark,databricks","pig,yahoo","spark,amplab","hive,facebook","pig,google")

    /* Group by first element of each of the strings in list */
    val grpdListRdd  = sc.parallelize(pairList).groupBy(x => x.split(",")(0))
    
    /* Output would be like following:
    (pig,CompactBuffer(pig,yahoo, pig,google))
    (spark,CompactBuffer(spark,databricks, spark,amplab))
    (hive,CompactBuffer(hive,facebook))
    */
  }
}
