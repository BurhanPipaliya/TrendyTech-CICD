import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger

object movieRating extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","movieRating")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week9 Spark basics/moviedata.data")
  
  val mappedInput = input.map(x=>x.split("\t")(2)).cache() // tab separated data getting 3rd column
  
  val results = mappedInput.countByValue()  // will count how many times value is come // it is an action
  
//  val ratings = mappedInput.map(x=>(x,1)) // (3,1) (4,1) (5,1)
//  
//  val reducedRating = ratings.reduceByKey((x,y) => x+y)
//  
//  val results = reducedRating.collect
//  
//    results.foreach(println)
  
  
}