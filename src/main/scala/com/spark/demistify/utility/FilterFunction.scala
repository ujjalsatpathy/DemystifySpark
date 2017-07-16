package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Ujjal Satpathy on 7/14/2017.
  */
object FilterFunction {
  /**
    * This function describes the usecases of rdd filter fn.
    *
    * @param args
    */
  def main(args: Array[String]):Unit = {

    val conf = new SparkConf().setMaster("local[*]").setAppName("map")
    val sc = new SparkContext(conf)

    /*Define input elements*/
    val list  = List(10,20,30,40,50)
    val map   = Map[Int,String](1->"aaa",2->"bbb",3->"ccc",4->"ddd")

    /*Create inputrdds*/
    val listRdd  = sc.parallelize(list)
    val mapRdd   = sc.parallelize(List(map))

    /* Iterate each of 'InputRdd' and apply filter logic to each of the rdd elements. */
    val fltrdListRdd  = listRdd.filter(_ >= 30)    //Filtering out rdd elements gt 30
    val fltrdMapRdd   = mapRdd.filter(filterMap)

  }

  def filterMap(input: Map[Int,String]):Boolean ={
      input.head._1 > 30
  }
}
