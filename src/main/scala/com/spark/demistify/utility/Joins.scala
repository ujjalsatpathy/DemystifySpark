package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Ujjal Satpathy on 7/17/2017.
  */
object Joins {
  /**
    * This function describes the usecases of rdd joins.
    *
    * @param args
    */
  def main(args: Array[String]) = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("join")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val random = new scala.util.Random()
    val inputList = (1 to 10000).toList
    val inputTuple = (1 to 20).toList.map(x => (x,random.nextPrintableChar()))
    val pairedList = for(i <- inputList) yield (random.nextInt(i),random.nextString(i))

    /*Create pair rdd from input*/
    val inputTupleRdd = sc.parallelize(inputTuple)
    val pairedListRdd = sc.parallelize(pairedList)

    /*Join both the rdds*/
    val joinedRdd = pairedListRdd.join(inputTupleRdd)
    val leftJoinRdd = pairedListRdd.leftOuterJoin(inputTupleRdd)
    val rightJoinRdd = pairedListRdd.rightOuterJoin(inputTupleRdd)

    /*Join using broadcast.Its a best approach to use broadcast if one of the table is small enough to fit in memory.*/
    val broadcastTuple = sc.broadcast(inputTuple.toMap)
    val broadcastJoin = pairedListRdd.map(x => (x,broadcastTuple.value.getOrElse(x._1,"_")))

  }
}
