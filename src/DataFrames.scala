import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.Dataset




object DataFrames extends App{
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf().set("spark.app.name", "MyApp")
  .set("spark.master", "local[*]")
  
  val spark = SparkSession.builder()
//  .appName("My App")
//  .master("local[*]")
  .config(sparkConf)
  .getOrCreate()
  
  val orderDf  = spark.read
  .option("header",true) // get the header
  .option("inferSchema", true) // guess the schema of the data. not recommended in production
  .csv("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week11 Spark Structured API/dataset/orders.csv")
  
  //orderDf.printSchema() // print the schema of the data
  //orderDf.show() // get only first 20 records
  
  val groupDf = orderDf
  .repartition(4)
  .where("order_customer_id > 10000")  // conditions
  .select("order_id", "order_customer_id") // select columns
  .groupBy("order_customer_id") // grouping the data by column values
  .count() // count the values
  
  
  groupDf.show()
   
  Logger.getLogger(getClass.getName).info("This is the current class DataFrames") // to deBug the app
  
  //stop spark session
  spark.stop()
  
}