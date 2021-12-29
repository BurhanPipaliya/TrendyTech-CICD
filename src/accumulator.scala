import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source

object accumulator extends App {
  
  
   Logger.getLogger("org").setLevel(Level.ERROR)
  
   val sc = new SparkContext("local[*]","accumulator")
   
   val input = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/sample_file.txt")
  
   val myacc = sc.longAccumulator("blank lines accumulator") // inital accumulator
   
   input.foreach(x => if(x == "") myacc.add(1)) // check the blank lines in file and add one to accumulator
   
   val result = myacc.value
   
//   println(result)
   
   
   val a = List(1,2)
   val b = List(3,4)
   
   val rdd1 = sc.parallelize(a)
   val rdd2 = sc.parallelize(b)
   
   val rdd3 = rdd1.map(x => (1,x)) // (1,1)(1,2)
     
   val rdd4 = rdd2.map(x =>(1,x)) // (1,3)(1,4)
   
   val rdd5 = rdd3.join(rdd4) // (1,(1,3)) (1,(1,4)) (1,(2,3)) (1,(2,4))
   
  val result1 = rdd5.map( x => x._2._1 + x._2._2)
   result1.collect().foreach(println)



   
   rdd5.foreach(println)
   
   
   
}