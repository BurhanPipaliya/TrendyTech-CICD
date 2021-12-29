object scala1 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(41); 

  println("Hello There");$skip(42); 
 // val a : String = "HellO"
  println(a);$skip(71); 
  if(1>3)
  {
  println("Hello")
  }
  else
  {
  println("there")
  };$skip(72); 
  
  for(x <- 1 to 10)
  {
  var squared = x*x
  //println(squared)
  };$skip(12); 
  var i = 0;System.out.println("""i  : Int = """ + $show(i ));$skip(53); 
   while ( i <= 10){
   //println(i)
   i = i+1
   };$skip(65); 
   val a = 10; val b = if (a==5) println("hello"); else (1,"hi");System.out.println("""a  : Int = """ + $show(a ));System.out.println("""b  : Any = """ + $show(b ))}
}
