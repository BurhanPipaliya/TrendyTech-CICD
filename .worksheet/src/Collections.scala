object Collections {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(49); 
  var a = Array(1,2,3,4,5,6);System.out.println("""a  : Array[Int] = """ + $show(a ));$skip(7); val res$0 = 
  a(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(11); 
  a(1) = 4;$skip(27); 
  println(a.mkString(","));$skip(38); 
  
  var b = List(1,2,3,4,5,"Burhan");System.out.println("""b  : List[Any] = """ + $show(b ));$skip(7); val res$1 = 
  b(5);System.out.println("""res1: Any = """ + $show(res$1));$skip(10); val res$2 = 
  15 :: b;System.out.println("""res2: List[Any] = """ + $show(res$2));$skip(51); 
  
 	//b(1) = 4
 	
 	var c = ("Burhan",10000,true);System.out.println("""c  : (String, Int, Boolean) = """ + $show(c ));$skip(10); val res$3 = 
 	
 	c._1;System.out.println("""res3: String = """ + $show(res$3));$skip(7); val res$4 = 
 	c._2;System.out.println("""res4: Int = """ + $show(res$4));$skip(23); 
 	
 	var rng = 1 to 10;System.out.println("""rng  : scala.collection.immutable.Range.Inclusive = """ + $show(rng ));$skip(29); 
 	for(i <- rng)
 	println(i);$skip(39); 
 	
 	var z = Set(1111,2,2,3,4,5,5,6,5);System.out.println("""z  : scala.collection.immutable.Set[Int] = """ + $show(z ));$skip(49); 
  
  var f  = Map(1 -> "Burhan",2 -> "Mohammed");System.out.println("""f  : scala.collection.immutable.Map[Int,String] = """ + $show(f ));$skip(11); val res$5 = 
  f.get(2);System.out.println("""res5: Option[String] = """ + $show(res$5))}
  
}
