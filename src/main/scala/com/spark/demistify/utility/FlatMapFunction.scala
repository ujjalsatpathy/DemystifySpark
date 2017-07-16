package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.log4j.Logger
import org.apache.log4j.Level

/**
  * Created by eujjsat on 7/16/2017.
  */
object FlatMapFunction {
  /**
    * This function describes the usecases of rdd flatMap fn.
    *
    * @param args
    */
  def main(args: Array[String]) = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val list  = List("spark is a distributed processing framework")

    /*Create inputrdds*/
    val listRdd  = sc.parallelize(list)

    /* Iterate each of 'InputRdd' and apply certain functions to each of the rdd elements and flateen the result. */
    val fltndListRdd = listRdd.flatMap(_.split(" "))

    //if we use map(..) instead of flatMap(..),it would give unflattened result like array of string.
    //As we have used flatMap the result is already flattened and would be in simple String format.
  }
}