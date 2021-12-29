import scala.io.StdIn._

object reverseString {
  def main(args: Array[String]) {
    val input = readLine()

    val output1 = input.reverse // just reverse the array
    println(output1)

    val output2 = input.split(" ").map(_.reverse) //split by space and reverse each given word
    println(output2.mkString(" ")) // mkstring is used to give string as a one line

    val output3 = input.split(" ").reverse // reverse the position of the word
    println(output3.mkString(" "))

  }                                               //> main: (args: Array[String])Unit
}