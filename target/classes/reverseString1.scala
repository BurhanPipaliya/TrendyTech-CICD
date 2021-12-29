import scala.io.StdIn._

object reverseString1 {
   def main(args: Array[String]) {
    val input = readLine()

    val output1 = input.reverse // just reverse the array
//    println(output1)

    val output2 = input.split(" ").map(_.reverse) //split by space and reverse each given word
//    println(output2.mkString(" ")) // mkstring is used to give string as a one line

    val output3 = input.split(" ").reverse // reverse the position of the word
//    println(output3.mkString(" "))

    
    val c = Nil
    println(c) // return empty list
    
    
    def fun = { throw new  Exception}  // return nothing
    
    
    def getString(num :Int): Option[String] ={
      
      if(num>=0)  Some("Positive")
      else None
        }
     
    def printResult(num:Int) = {
       getString(num) match {
         case Some(str) => println(str)
         case None => println("No string!")
       }
     }
//    printResult(-1)
    // How to handle null values
    case class Address (city: String,state:String)
    
    class User (email: String, password: String){
      var firstName : Option[String] = None 
      var lastName : Option[String] = None
      var address : Option[Address] = None
    }
    
    var usr = new User("burhan@gmail","abcd")
    usr.firstName = Some("Burhan")  // can't be stored in variablee
    
    println(usr.firstName.getOrElse("Nothing assigned")) // if some value is assigned it will print the value of getOrElse will print 'not assigned'.
    
    
    
    
    
  }  
}