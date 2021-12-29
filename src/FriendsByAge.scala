import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger

object FriendsByAge extends App {
  
  def parseLine(line:String) = {
    val fields = line.split(",")
    val age = fields(2).toInt
    val num_connections = fields(3).toInt
    
    (age,num_connections)
  }
  Logger.getLogger("org").setLevel(Level.ERROR)
  
   val sc = new SparkContext("local[*]","friendsbyage")
  
   val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week9 Spark basics/friendsdata.csv")
   
   val mappedInput = input.map(parseLine)
   
//   val mappedFinal = mappedInput.map(x=>(x._1,(x._2,1))) // (33,(100,1) (33,(200,2)
   
   val mappedFinal = mappedInput.mapValues(x => (x,1))
   val totalByAge = mappedFinal.reduceByKey((x,y) => (x._1 + y._1,x._2 + y._2)) // (33,(300,2))
   
   val avg  = totalByAge.map(x => (x._1,x._2._1/x._2._2)) // (33, 150) e.g 300/2
      
   avg.collect().foreach(println)
       
       
   
   
   
}