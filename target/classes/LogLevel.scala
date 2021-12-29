
import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source

object LogLevel extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","LogLevel")
  
  val myList = List("WARN: Wed Jul 01 10:37:51 BST 2015",
"WARN: Wed Jul 01 10:37:51 BST 2015",
"ERROR: Wed Jul 01 10:37:51 BST 2015",
"ERROR: Wed Jul 01 10:37:51 BST 2015",
"WARN: Wed Jul 01 10:37:51 BST 2015",
"ERROR: Wed Jul 01 10:37:51 BST 2015",
"WARN: Wed Jul 01 10:37:51 BST 2015",
"WARN: Wed Jul 01 10:37:51 BST 2015")


val newRDD = sc.parallelize(myList) // parallelize is used to distribute local data into cluster

//val logLevel1 = newRDD.map(x => (x.split(":")(0),1))

val logLevel1 = newRDD.map(x => {
  val level = x.split(":") // split based on :
  val columns = level(0) // get the 1st element from the array
  (columns, 1)
  
}).reduceByKey((x,y ) => x+ y).collect.foreach(println)

//val result = logLevel1.reduceByKey((x,y ) => x+ y)


//result.collect.foreach(println)
}