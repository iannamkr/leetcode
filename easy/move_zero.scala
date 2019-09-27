package sample

object Solution {
  def moveZeroes(nums: Array[Int]): Unit = {
    var pos = 0
    for(i <- nums.indices) {
      val num = nums(i)
      if(num != 0) {
        nums(pos) = nums(i)
        pos += 1
      }
    }
    for(i <- 1 to ((pos - 1))) {
      nums(nums.length - i) = 0
    }
  }

  def main(args: Array[String]): Unit = {
    val input: Array[Int] = Array(0,1,0,3,12)
    moveZeroes(input)
  }
}
