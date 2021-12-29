import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger

object WordCount extends App {
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","wordcount")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week9 Spark basics/search_data.txt")
  
  val words = input.flatMap(x => x.split(" ")) // split each word through space (_.split(" "))
  
  val wordsLower = words.map(_.toLowerCase())
  val eachWord = wordsLower.map(x => (x,1))  // give output like (big,1) (data,1) like a tuple  // (_,1)
  
  val totalWord = eachWord.reduceByKey((x,y) => (x+y)) // work on two input rows and group them by key and add the value of each key
  // like (big,5) (data,10) (_,_)
  
  val reversedTuple = totalWord.map(x => (x._2,x._1)) // x._2 = value and x._1 is key (shuffle key with value and use sortByKey to get highest number of values
  
  
  val totalWord2 = reversedTuple.sortByKey(false).map(x=>(x._2,x._1))// by default true means ascending order
  
 val results = totalWord2.collect
  for (result <- results){
    val word = result._1
    val count = result._2
    println(s"$word : $count")
      
  }
  //totalWord2.collect.foreach(println)
  
//  scala.io.StdIn.readLine() // to get a hold of program to visualize DAG
//  totalWord.saveAsTextFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/sparkoutput")
  
  
  
}