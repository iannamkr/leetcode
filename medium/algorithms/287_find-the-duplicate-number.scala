object Solution {
  def findDuplicate(nums: Array[Int]): Int = {
    val seen = scala.collection.mutable.Set.empty[Int]

    var dup = nums(0)
    import scala.util.control.Breaks._
    breakable {
      for (num <- nums) {
        if (seen.contains(num)) {
          dup = num
          break
        }
        else {
          seen.add(num)
        }
      }
    }
    dup
  }
}
