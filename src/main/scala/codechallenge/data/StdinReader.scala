package codechallenge.data

import scala.io.StdIn
import scala.util.Try

class StdinReader extends IRead {

  def read(): List[List[Int]] = {
    val input = Iterator.continually(StdIn.readLine())
      .takeWhile(line => line.nonEmpty && line != "EOF")
      .toList

    input match {
      case x if x == null || x.isEmpty || x.length < 2 => List.empty
      case _ =>
        val ints = input.map { line =>
          val tokens = line.trim.split("\\s+")
          if (tokens.forall(s => s.matches("-?\\d+"))) {
            val parsed = tokens.map(s => Try(s.toInt).toOption)
            if(parsed.contains(None)) None
            else Some(parsed.flatten.toList)
          }
          else None
        }
        if (ints.contains(None)) List.empty
        else ints.flatten
    }
  }
}
