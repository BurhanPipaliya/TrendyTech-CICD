import org.apache.spark.SparkContext
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark
import org.apache.log4j
import scala.math.min


object MinTemp extends App {
  
  def parseLine(line:String) = {
    val fields = line.split(",")
    val stationId = fields(0)
    val entryType = fields(2)
    val temperature = fields(3)
    
    (stationId,entryType,temperature)
     
  }

  Logger.getLogger("org").setLevel(Level.ERROR)
  
  
  val sc = new SparkContext("local[*]","MinTemp")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Downloads/tempdata.csv")
  
  val mappedInput = input.map(parseLine)
  
  val stationTemp = mappedInput.map(x => (x._1,x._3.toFloat))
  
  // retaning min number of temperature
  
  val minTempByStation = stationTemp.reduceByKey((x,y) => min(x,y))
  
  val results = minTempByStation.collect()
  
  for (result <- results.sorted)  {
    val station = result._1
    val temp = result._2
    
    val formatted = f"$temp%.2f F"
    
    println(s"$station minimum temperature: $formatted")
  }

}