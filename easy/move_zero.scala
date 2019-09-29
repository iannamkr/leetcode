package sample

object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    val nonZero = nums.filter(_ != 0)
    nonZero ++ Array.fill(nums.length - nonZero.length){0}
  }

  def main(args: Array[String]): Unit = {
    val input: Array[Int] = Array(0,1,0,3,12)
    moveZeroes(input)
  }
}
