import codechallenge.FindMinPath
import org.scalatest.funsuite.AnyFunSuite

class FindMinPathSpec extends AnyFunSuite {

  test("Valid triangle should return minimal path") {
    val triangle = List(
      List(7),
      List(6, 3),
      List(3, 8, 5),
      List(11, 2, 10, 9)
    )
    val result = new FindMinPath().execute(triangle)
    assert(result == "Minimal path is: 7 + 6 + 3 + 2 = 18")
  }

  test("Another triangle should return correct minimal path") {
    val triangle = List(
      List(5),
      List(9, 6),
      List(4, 6, 8),
      List(0, 7, 1, 5)
    )
    val result = new FindMinPath().execute(triangle)
    assert(result == "Minimal path is: 5 + 6 + 6 + 1 = 18")
  }

  test("Empty triangle should return error message") {
    val result = new FindMinPath().execute(List.empty)
    assert(result == "Not a valid triangle")
  }

  test("Triangle with one element should return error message") {
    val triangle = List(List(42))
    val result = new FindMinPath().execute(triangle)
    assert(result == "Not a valid triangle")
  }

  test("Triangle with two levels should return minimal path correctly") {
    val triangle = List(
      List(1),
      List(10, 1)
    )
    val result = new FindMinPath().execute(triangle)
    assert(result == "Minimal path is: 1 + 1 = 2")
  }
}
