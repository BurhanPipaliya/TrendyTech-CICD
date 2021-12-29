import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source

object logLevelGrouping extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","LogLevelGroup")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week10 Spark in-depth/biglog.txt")
  
  val mappedRdd = input.map(x => {
    val fields = x.split(":")
    (fields(0),fields(1))
  })
  mappedRdd.groupByKey.collect().foreach(x => println(x._1,x._2.size)) // printing size of list
  
 
  
  
}