import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkConf
import org.apache.log4j.Level
import org.apache.log4j.Logger
import org.apache.spark.sql.Dataset
import java.security.Timestamp
import org.apache.spark.sql.types.StructType
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.types.StructField
import org.apache.spark.sql.types.TimestampType




// Case class to convert DF to DS.
case class OrderData(order_id : Int, order_date: Timestamp, order_customer_id : Int, order_status : String)

object DataFrametoDataSet extends App {
  Logger.getLogger("org").setLevel(Level.ERROR)
  val sparkConf = new SparkConf()
  .set("spark.app.name", "MyApp")
  .set("spark.master", "local[*]")
  
  val spark = SparkSession.builder()
//  .appName("My App")
//  .master("local[*]")
  .config(sparkConf)
  .getOrCreate()
  
  
  // Explicit Schema 
  val orderSchema = StructType(List( // StructType is for row level and field is for values 
    StructField("order_id",IntegerType ,false), // In scala it is int but in spark it is IntegerType // nullable = false
    StructField("order_date",TimestampType),
    StructField("customer_id",IntegerType),
    StructField("order_status",IntegerType),
 ))
    
    
    
    // DDL method 
   val  orderSchemaDDL = "orderId int, orderDate timestamp,order_customer_id int,status string"
  val orderDf  = spark.read
  .format("csv")
  .option("header",true) // get the header
  .schema(orderSchema) // Explicit schema 
  .option("path","C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week11 Spark Structured API/dataset/orders.csv")
  .load 
  
  
 
//  import spark.implicits._ // casting 
  
//  val orderDs = orderDf.as[OrderData] // Dataset[OrderData]
  
//  orderDs.filter(x => x.order_id > 10)
  
  
  
  //Read Parquet file 
//   val orderDf  = spark.read
//  .format("parquet")
//  .option("path","C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week11 Spark Structured API/dataset/users.parquet")
//  .load 
  
  
  orderDf.show(false) // truncate is false by default it is true
  
}