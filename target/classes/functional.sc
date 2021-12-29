object functional {
    def square(x:Int) : Int = {
    	 x*x
       
    }                                             //> square: (x: Int)Int
    println(square(5))                            //> 25
    
    def transform(x:Int,f:Int => Int): Int = {
     f(x)
    }                                             //> transform: (x: Int, f: Int => Int)Int
    transform(2,square)                           //> res0: Int = 4
    transform(2,x => x*x*x)                       //> res1: Int = 8
    
    def oddEven(x:Int) = {
    if(x % 2 ==  0) {
   		println("Even")
    }
    else {
    	println("ODD")
    }
    }                                             //> oddEven: (x: Int)Unit
    oddEven(4)                                    //> Even
}