package sample

object DailyTemperatures {
  def dailyTemperatures(T: Array[Int]): Array[Int] = {
    var pos = 0
    var i = 1
    val returns = new Array[Int](T.length)
    while(pos < T.length && i < T.length) {
      if(T(pos) < T(i)) {
        returns(pos) = i - pos
        pos += 1
        i = pos + 1
      } else if (i >= T.length -1) {
        returns(pos) = 0
        pos += 1
        i = pos + 1
      } else {
        i += 1
      }
    }
    returns
  }

  def main(args: Array[String]): Unit = {
    val input: Array[Int] = Array(55,38,53,81,61,93,97,32,43,78)
    dailyTemperatures(input).foreach(println)
  }
}
