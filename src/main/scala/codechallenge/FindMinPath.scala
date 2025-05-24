package codechallenge

import scala.collection.mutable

class FindMinPath() {

  def execute(triangle: List[List[Int]]): String = {
    if (triangle.isEmpty || triangle.length < 2) return "Not a valid triangle"

    val size = triangle.size
    val minPaths: mutable.Map[Int, List[Int]] = mutable.Map.empty

    (size - 2 to 0 by -1).foreach { rowIndex =>
      val nextRow: List[Int] = triangle(rowIndex + 1)

      triangle(rowIndex).zipWithIndex.foreach { case (vertice, index) =>
        val child1: Int = nextRow(index)
        val child2: Int = nextRow(index + 1)

        if (minPaths.nonEmpty) {
          val currentPath: List[Int] = setCurrentPath(minPaths, child1, child2)

          minPaths -= currentPath.head
          minPaths ++= mutable.Map(vertice -> currentPath)
        } else {
          val minVerticeChild: Int = List(child1, child2).min
          minPaths ++= mutable.Map(vertice -> List(minVerticeChild))
        }
      }
    }

    buildResult(triangle, minPaths)
  }

  private def setCurrentPath(minPaths: mutable.Map[Int, List[Int]], child1: Int, child2: Int) = {
    def totalCost(node: Int): Int = minPaths.get(node).map(_.sum).getOrElse(0) + node

    val (minVerticeChild, existentVertices) = {
      val cost1 = totalCost(child1)
      val cost2 = totalCost(child2)

      if (cost1 < cost2) (child1, minPaths.getOrElse(child1, List.empty))
      else (child2, minPaths.getOrElse(child2, List.empty))
    }
    List(minVerticeChild) ++ existentVertices
  }

  private def buildResult(triangle: List[List[Int]], minPaths: mutable.Map[Int, List[Int]]) = {
    minPaths.find(_._2.length == triangle.length - 1).map { case (k, v) =>
      val sum = (List(k) ++ v).sum
      s"Minimal path is: ${(List(k) ++ v).mkString(" + ")} = $sum"
    }.head
  }
}
