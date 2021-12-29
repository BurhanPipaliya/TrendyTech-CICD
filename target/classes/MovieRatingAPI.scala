import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger


object MovieRatingAPI extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","topmovie")
  
  val movieRdd = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week11 Spark Structured API/dataset/movies.dat")
  
  val ratingRdd = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week11 Spark Structured API/dataset/ratings.dat")

  val mappedRdd = ratingRdd.map(x=> {
    val fields = x.split("::") //(1193,5)(1193,4)
    
    (fields(1),fields(2))
    
    // calcuate the average (1193,(5,1)(1193,(4,1))
    
    //mapValues key is unchange so mapValues
})

    val newMapped = mappedRdd.mapValues(x => (x.toFloat,1.0))
      //input (1193,(5,1)(1193,(4,1))
     
    
    val reducedRdd = newMapped.reduceByKey((x,y) =>(x._1+y._1,x._2+y._1))
      //output (1193,(9,2))
    
    val filterRdd = reducedRdd.filter(x=> x._2._2>100) // only movie whose have 1000 + rating 
      
    val averageRdd = filterRdd.mapValues(x => x._1/x._2).filter(x=> x._2>4.5) // average &  rating should be 4.5 +
    
   /// Processing movie data
    
   val mappedMovie =  movieRdd.map(x => {
      val fields = x.split("::")
      (fields(0),fields(1))
    })
    // join two rdd based on key (101,4.5) (101,Toy story) // output after join (101,(Toy story,4.5)
    
    val joinedRdd = mappedMovie.join(averageRdd)
    
    val toppedMovie = joinedRdd.mapValues(x => x._2)
    
    toppedMovie.take(20) // top 20 records
    
    
    



}
