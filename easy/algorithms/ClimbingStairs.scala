object ClimbingStairs {
  def climbStairs(n: Int): Int = {
    val cases = new Array[Int](n + 2)
    cases(0) = 1
    cases(1) = 1

    for(step <- 2 to n) {
      cases(step) = cases(step - 2) + cases(step - 1)
    }
    cases(n)
  }

  def main(args: Array[String]): Unit = {
    print(climbStairs(10))
  }
}
