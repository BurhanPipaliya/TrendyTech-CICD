import scala.io.StdIn._

object perfSquare {

  def main(args: Array[String]) {

    val numCustomers = readInt // take one user input as int

    val billAmount = readLine // read each line as a string

    //billAmount.split(" ").map(x =>x.toInt) // split each string by space and convert into int by map function
    val billAmt = billAmount.split(" ").map(_.toInt)
    var count = 0
    for (i <- billAmt) {
      var sqrt = math.sqrt(i).ceil - math.sqrt(i) // check if the number is 0  if 15 -- 4-3.9 ---0.1 it is false

      if (sqrt == 0) {
        count = count + 1

      }
    }
    println(count)
  }                                               //> main: (args: Array[String])Unit
}