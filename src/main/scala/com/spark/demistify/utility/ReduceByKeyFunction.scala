package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Ujjal Satpathy on 7/17/2017.
  */
object ReduceByKeyFunction {
  /**
    * This function describes the usecases of rdd reduceByKey fn.
    *
    * @param args
    */
  def main(args: Array[String]) = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("reducebykey")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val pairList = List(("California",12),("Los Angeles",47),("NewYork",58),("Ohio",59),("Los Angeles",23),("NewYork",53))

    /*Create pair rdd from input*/
    val pairedListRdd = sc.parallelize(pairList)
    /* Calculate sum of values for each key group */
    val reducedPairedListRdd = pairedListRdd.reduceByKey(_+_)

    println(s"Ouput rdd count = ${reducedPairedListRdd.count()}")
  }
}
