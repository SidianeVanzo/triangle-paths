package codechallenge.data

import scala.io.Source

class FileReader extends IRead {

  override def read(): List[List[Int]] = {
    Source.fromFile(s"src/main/resources/data_small.txt").getLines().map { line =>
      line.split("\\s+").map(_.toInt).toList
    }.toList
  }

}
