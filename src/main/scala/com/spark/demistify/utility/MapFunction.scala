package com.spark.demistify.utility

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by eujjsat on 7/14/2017.
  */
object MapFunction {
  /**
    * This function describes the usecases of rdd map fn.
    * @param args
    */
 def main(args: Array[String]) = {

   val conf = new SparkConf().setMaster("local[*]").setAppName("map")
   val sc   = new SparkContext(conf)

   /*Define input elements*/
   val list  = List(10,20,30,40,50)
   val map   = Map[Int,String](1->"aaa",2->"bbb",3->"ccc",4->"ddd")
   val tuple = ((10,"aaa"),(20,"bbb"))


   /*Create inputrdds*/
   val listRdd  = sc.parallelize(list)
   val mapRdd   = sc.parallelize(List(map))          //Cannot create rdd directly from map or tuple,
   val tupleRdd = sc.parallelize(List(tuple))      // --convert them to Seq or List.

   /* Iterate each of 'InputRdd' and apply certain functions to each of the rdd elements. */
   val mappedListRdd = listRdd.map(x => x+10)  //add 10 to each of the list elements.
   val mappedMapRdd = mapRdd.map(x => (x.keys.head+10-> x.values.head))   //add 10 to key of each of the maps.
   val mappedTunpleRdd = tupleRdd.map{case((a,b),(x,y)) => ((a+10,b),(x+10,y))} //add 10 to the first element of each of the tuples.

  }
}
