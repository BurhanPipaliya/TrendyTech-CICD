import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger

object customerAmount extends App {
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","customerAmount")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week9 Spark basics/customerorders.csv")
  
  val mappedInput = input.map(x =>(x.split(",")(0),x.split(",")(2).toFloat))  // work on one input row // get element 1 and 3 in form of tuple
  
  val totalAmount = mappedInput.reduceByKey((x,y) => (x+y)) // aggreation by key and add the value (Paired RDD)
  
  val finalResult = totalAmount.sortBy(x=>x._2)
  
  
  finalResult.foreach(println)
   
  
  
  
}