object Factorial {
   //Recursion
   
   def fact(input:Int):Int = {
   if(input == 1 ) 1
   
   else return input * fact(input-1)
   }                                              //> fact: (input: Int)Int
   
   fact(6)                                        //> res0: Int = 720
   
   // for loop
   
   def fact1(input:Int):Int = {
     var result = 1
     for ( i <- 1 to input) {
      result = result * i
     }
     return result
   }                                              //> fact1: (input: Int)Int
   
   fact1(5)                                       //> res1: Int = 120
   
   //tail recursion
   
   def fact2(input:Int,result:Int):Int = {
   if(input==1) result
   else fact2(input-1,result*input)
   }                                              //> fact2: (input: Int, result: Int)Int
   fact2(4,1)                                     //> res2: Int = 24
 }