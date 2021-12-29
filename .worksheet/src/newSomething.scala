object newSomething {

  object Person { // class level functionality like static method in java
  val newEyes = 4
  def canFly : Boolean = false
  
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(178); 
  println(Person.newEyes)


  class Person(name:String,age:Int){ // instance level functionality
  val x = 20
  
  def agedoubler = age*20
  def salary(salary:Int) = salary*2
  
 };$skip(221); 
  

    
    //companion design
  val p = new Person("Burhan",24);System.out.println("""p  : newSomething.Person = """ + $show(p ));$skip(15); 
  println(p.x);$skip(15); val res$0 = 
  p.agedoubler;System.out.println("""res0: Int = """ + $show(res$0));$skip(17); val res$1 = 
  p.salary(1000);System.out.println("""res1: Int = """ + $show(res$1));$skip(26); 
  println(Person.newEyes);$skip(18); val res$2 = 
  p.salary(10000);System.out.println("""res2: Int = """ + $show(res$2))}
}


object newSomething1{
  abstract class Animal {
  val creatureType:String
  def eat
  }
  class Dog extends Animal {
  val creatureType:String = "Canine"
  def eat:Unit = println("We eat a lot")
  }
  val dog = new Dog
  dog.eat
}
