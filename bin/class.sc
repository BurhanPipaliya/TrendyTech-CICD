object newSomething {

  object Person { // class level functionality like static method in java
  val newEyes = 4
  def canFly : Boolean = false
  
  }
  println(Person.newEyes)                         //> 4


  class Person(name:String,age:Int){ // instance level functionality
  val x = 20
  
  def agedoubler = age*20
  def salary(salary:Int) = salary*2
  
 }
  

    
    //companion design
  val p = new Person("Burhan",24)                 //> p  : newSomething.Person = newSomething$Person$1@21bcffb5
  println(p.x)                                    //> 20
  p.agedoubler                                    //> res0: Int = 480
  p.salary(1000)                                  //> res1: Int = 2000
  println(Person.newEyes)                         //> 4
  p.salary(10000)                                 //> res2: Int = 20000
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