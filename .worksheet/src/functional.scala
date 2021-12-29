object functional {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(75); 
    def square(x:Int) : Int = {
    	 x*x
       
    };System.out.println("""square: (x: Int)Int""");$skip(23); 
    println(square(5));$skip(68); 
    
    def transform(x:Int,f:Int => Int): Int = {
     f(x)
    };System.out.println("""transform: (x: Int, f: Int => Int)Int""");$skip(24); val res$0 = 
    transform(2,square);System.out.println("""res0: Int = """ + $show(res$0));$skip(28); val res$1 = 
    transform(2,x => x*x*x);System.out.println("""res1: Int = """ + $show(res$1));$skip(124); 
    
    def oddEven(x:Int) = {
    if(x % 2 ==  0) {
   		println("Even")
    }
    else {
    	println("ODD")
    }
    };System.out.println("""oddEven: (x: Int)Unit""");$skip(15); 
    oddEven(4)}
}
