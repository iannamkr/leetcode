object SingleNumber {
  def singleNumber(nums: Array[Int]): Int = nums.reduceLeft(_ ^ _)

  def main(args: Array[String]): Unit = {
    val input: Array[Int] = Array(4,1,2,1,2,5)
    print(singleNumber(input))
  }
}
