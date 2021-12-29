import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger

object costByWord extends App{
  def parseLine(line:String) = {
    val fields = line.split(",")
    val searchWord = fields(10).toFloat
    val cost = fields(0)
    
    (searchWord,cost)
    
  }
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","costbyword")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/bigdatacampaigndata.csv")
  
  val mappedInput = input.map(parseLine) // (24.06, big data course) 
   
  val flatInput =  mappedInput.flatMapValues(x => x.split(" ")) // (24.06, big) (24.06,data) (24.06,course)
  
  val finalMap = flatInput.map(x => (x._2.toLowerCase(),x._1)) // interchange key with value  (big,24.06)
  
  val finalCount = finalMap.reduceByKey((x,y) => x+y)
  
  val sort = finalCount.sortBy(x => x._2,false)
  
  sort.take(20).foreach(println) // get only top 10
   
  
}