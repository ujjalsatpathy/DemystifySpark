package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by eujjsat on 7/14/2017.
  */
object HighOrderMap {
  /**
    * This function describes the usecases of high order rdd map fn.
    * @param args
    */
  def main(args: Array[String]) = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val list  = List(10,20,30,40,50)
    val map   = Map[Int,String](1->"aaa",2->"bbb",3->"ccc",4->"ddd")

    /*Create inputrdds*/
    val listRdd  = sc.parallelize(list)
    val mapRdd   = sc.parallelize(List(map))

    //Calling high order function.
    val highOrdrdListRdd = listRdd.map(highOrderParser)
    val highOrdrdMapRdd = mapRdd.map(highOrderParser)
    highOrdrdMapRdd.foreach(println)
  }
   /*High order function to be called in rdd map function*/
  def highOrderParser[T](input:T): Any ={
    input match {
      case s:Int => s+10
      case v:Map[Int,String] => v.map(x => Map(x._1+10->x._2))
      case _ => ""
    }
  }
}
