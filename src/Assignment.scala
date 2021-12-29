import org.apache.spark.SparkContext

import org.apache.log4j.Level
import org.apache.log4j.Logger
import scala.io.Source

object Assignment extends App {
   Logger.getLogger("org").setLevel(Level.ERROR)
  
  val sc = new SparkContext("local[*]","LogLevelGroup")
   // chapter data
  val chaptersRdd = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week10 Spark in-depth/Dataset/chapters.csv")
  // views data
  val viewRdd = sc.textFile("C:/Users/Burhanuddin/Desktop/Bigdata Master Program Trendy Tech/week10 Spark in-depth/Dataset/views-*.csv")
  
  //Exercise1: Find Number of Chapters Per Course
  val mappedChapter = chaptersRdd.map(x => (x.split(",")(0).toInt,x.split(",")(1).toInt))
  
  val chapterCount = mappedChapter.map(x => (x._2,1)).reduceByKey((x,y) => x+y)
  
//  chapterCount.collect.foreach(println)
  
  // Exercise 2 
  
  //Step 1 (Remove duplicate views)
  val viewRddData = viewRdd.map(x=>(x.split(",")(0).toInt,x.split(",")(1).toInt))
  
  val distinctView = viewRddData.distinct()
  
  //  distinctView.foreach(println)
  
  //Step 2 Joining chapterDataRDD with viewDataDistinctRDD, to get CourseID also.Join key is chapterID

  //First flip the viewDataDistinctRDD to make chapterId as the key
  
  val flippedViewData = distinctView.map(x=>(x._2,x._1))
  
  // join mappedChapter with flippedViewData to get courseIds
  
  
  val joinedRdd = flippedViewData.join(mappedChapter)
  // (chapterId,(userId,courseId))
 // joinedRdd.collect.foreach(println)
  
  //Step 3: Dropping off the chapterIds and appending 1 as the value
  //(206,(182,14))
  val pairRdd = joinedRdd.map( x=> ((x._2._1,x._2._2),1))
//  pairRdd.collect().foreach(println)
  
  //((597,14),1) ((353,14),1)
  //Step 4 - Count Views for User/Course -Finding out count of number of chapters a user has watched per course
  val userPerCourseViewRDD = pairRdd.reduceByKey(_ + _)
  
//  userPerCourseViewRDD.collect.foreach(println)
  
  //Step 5 Dropping the UserID going forward
   
  val courseViewsCountRDD = userPerCourseViewRDD.map(x => (x._1._2,x._2)) // (courseId, Views)(13,7)
  
//  courseViewsCountRDD.collect.foreach(println)
  
  //Step-6 Join the chapterCountRDD with courseViewsCountRDD to integrate total chapters in a course
  
  
  val newJoinedRDD = courseViewsCountRDD.join(chapterCount)
  
//  newJoinedRDD.collect.foreach(println)
  
  
  //Step-7 Calculating Percentage of course completion
  
  val CourseCompletionpercentRDD = newJoinedRDD.mapValues(x => (x._1.toDouble/x._2))

//  CourseCompletionpercentRDD.collect.foreach(println)
  
  // formatting the rdd
  val formattedpercentageRDD =CourseCompletionpercentRDD.mapValues(x =>f"$x%01.5f".toDouble)
   
  //Step-8 Map Percentages to Scores

  val scoresRDD = formattedpercentageRDD.mapValues (x => {

 if(x >= 0.9) 10l
 else if(x >= 0.5 && x < 0.9) 4l
 else if(x >= 0.25 && x < 0.5) 2l
 else 0l

})
//  scoresRDD.collect.foreach(println)
  
  
  //Step -9 Adding up the total scores for a course
  
  val totalScorePerCourseRDD =scoresRDD.reduceByKey((V1,V2) => V1 + V2)
  
  totalScorePerCourseRDD.collect.foreach(println)
  
  
  
}