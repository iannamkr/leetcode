package sample

object Subsets {
  def subsets(nums: Array[Int]): List[List[Int]] = nums.toSet[Int].subsets().map(_.toList).toList


  def main(args: Array[String]): Unit = {
    val input: Array[Int] = Array(1, 2, 3)
    print(subsets(input))
  }
}
