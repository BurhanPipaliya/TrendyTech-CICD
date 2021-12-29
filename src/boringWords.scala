import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source

object boringWords extends App {
   def parseLine(line:String) = {
    val fields = line.split(",")
    val searchWord = fields(10).toFloat
    val cost = fields(0)
    
    (searchWord,cost)
    
  }
  def loadingBoringWords(): Set[String] = {
    var boringWords:Set[String] = Set()
    // getting line from local 
    val input = Source.fromFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/boring.txt").getLines()
    
    for (line <- input) {
      boringWords += line
    }
    boringWords
  }
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","boringword")
    
  var nameSet = sc.broadcast(loadingBoringWords) // broadcast variable
  
  val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/bigdatacampaigndata.csv")
  
  val mappedInput = input.map(parseLine) // (24.06, big data course) 
   
  val flatInput =  mappedInput.flatMapValues(x => x.split(" ")) // (24.06, big) (24.06,data) (24.06,course)
  
  val finalMap = flatInput.map(x => (x._2.toLowerCase(),x._1)) // interchange key with value  (big,24.06)
  //before reduceByKey we have to filter the data 
  
  val filterRDD = finalMap.filter(x => !nameSet.value(x._1)) // ignore the value in boringwords  !nameSet.value(x._1) = False
  
  
  
  val finalCount = filterRDD.reduceByKey((x,y) => x+y)
  
  val sort = finalCount.sortBy(x => x._2,false)
  
  sort.take(20).foreach(println) // get only top 10
  
}