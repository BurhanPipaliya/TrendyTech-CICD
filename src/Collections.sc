object Collections {
  var a = Array(1,2,3,4,5,6)                      //> a  : Array[Int] = Array(1, 2, 3, 4, 5, 6)
  a(4)                                            //> res0: Int = 5
  a(1) = 4
  println(a.mkString(","))                        //> 1,4,3,4,5,6
  
  var b = List(1,2,3,4,5,"Burhan")                //> b  : List[Any] = List(1, 2, 3, 4, 5, Burhan)
  b(5)                                            //> res1: Any = Burhan
  15 :: b                                         //> res2: List[Any] = List(15, 1, 2, 3, 4, 5, Burhan)
  
 	//b(1) = 4
 	
 	var c = ("Burhan",10000,true)             //> c  : (String, Int, Boolean) = (Burhan,10000,true)
 	
 	c._1                                      //> res3: String = Burhan
 	c._2                                      //> res4: Int = 10000
 	
 	var rng = 1 to 10                         //> rng  : scala.collection.immutable.Range.Inclusive = Range 1 to 10
 	for(i <- rng)
 	println(i)                                //> 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
                                                  //| 5
                                                  //| 6
                                                  //| 7
                                                  //| 8
                                                  //| 9
                                                  //| 10
 	
 	var z = Set(1111,2,2,3,4,5,5,6,5)         //> z  : scala.collection.immutable.Set[Int] = Set(5, 6, 1111, 2, 3, 4)
  
  var f  = Map(1 -> "Burhan",2 -> "Mohammed")     //> f  : scala.collection.immutable.Map[Int,String] = Map(1 -> Burhan, 2 -> Moha
                                                  //| mmed)
  f.get(2)                                        //> res5: Option[String] = Some(Mohammed)
  
}