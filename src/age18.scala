import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger

object age18 extends App{
  
  def Age(line:String) ={
    val fields = line.split(",")
    
    val age = fields(1).toInt
    
    if (age > 18){
      (fields(0),fields(1),fields(2),"Y")
    }
    else{
      (fields(0),fields(1),fields(2),"N")
    }
    
  }
  
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","age18")
  
  val input = sc.textFile("C:/Users/Burhanuddin/Downloads/data.dataset1")
  
  val mappedInput = input.map(Age)
  
  mappedInput.saveAsTextFile("C:/Users/Burhanuddin/Downloads/sparkoutput")
  
  
}