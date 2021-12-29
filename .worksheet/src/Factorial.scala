object Factorial {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(135); 
   //Recursion
   
   def fact(input:Int):Int = {
   if(input == 1 ) 1
   
   else return input * fact(input-1)
   };System.out.println("""fact: (input: Int)Int""");$skip(15); val res$0 = 
   
   fact(6);System.out.println("""res0: Int = """ + $show(res$0));$skip(162); 
   
   // for loop
   
   def fact1(input:Int):Int = {
     var result = 1
     for ( i <- 1 to input) {
      result = result * i
     }
     return result
   };System.out.println("""fact1: (input: Int)Int""");$skip(16); val res$1 = 
   
   fact1(5);System.out.println("""res1: Int = """ + $show(res$1));$skip(135); 
   
   //tail recursion
   
   def fact2(input:Int,result:Int):Int = {
   if(input==1) result
   else fact2(input-1,result*input)
   };System.out.println("""fact2: (input: Int, result: Int)Int""");$skip(14); val res$2 = 
   fact2(4,1);System.out.println("""res2: Int = """ + $show(res$2))}
 }
