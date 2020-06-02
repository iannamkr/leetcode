object PowerOfThree {
  // timeout
//  def isPowerOfThree(n: Int): Boolean = {
//    if(n == 1) true
//    else n % 3 == 0 && isPowerOfThree(n/3)
//  }

  // timeout
//  def isPowerOfThree(n: Int): Boolean = {
//    var tmp = n
//    while(tmp % 3 == 0)
//      tmp /= 3
//    tmp == 1
//  }

  def isPowerOfThree(n: Int): Boolean = (Math.log10(n) / Math.log10(3)) % 1 == 0

  def main(args: Array[String]): Unit = {
    print(isPowerOfThree(27))
  }
}
