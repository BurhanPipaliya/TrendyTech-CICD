import scala.io.StdIn._

object strictlyLesser {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(562); 
  def main(args: Array[String]) {

    val inputLine1 = readLine // read two input values as string
    val inputLine1Array = inputLine1.split(" ").map(_.toInt) //split and convert into int and store as array

    val inputLine2 = readLine
    val inputLine2Array = inputLine2.split(" ").map(_.toInt) // get second input same as above

    val numK = inputLine1Array(1)
    var count = 0
    for (i <- inputLine2Array) {
      if (i < numK) {
        count = count + 1

      }

    }
    println(count)
  };System.out.println("""main: (args: Array[String])Unit""")}
}
