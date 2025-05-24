package codechallenge

import codechallenge.data.{IRead, StdinReader}

object Main extends App{
  val reader: IRead = new StdinReader()
  val mainApp = new FindMinPath()
  val data = reader.read()
  println(mainApp.execute(data))
}
