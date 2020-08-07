object Solution {
    type d2 = (Int, Int)

    def updater(k: Int)(p: d2, num: Int): d2 = p match {
        case (sum, count) ⇒
            if(sum + num == k) {
                (sum + num, count + 1)
            } else {
                (sum + num, count)
            }
    }

    def subarraySum(nums: Array[Int], k: Int): Int = {
        val init = (0, 0)
        (0 to nums.length).map { x =>
            nums.slice(x, nums.length).foldLeft(init)(updater(k))._2
        }.sum
    }

    def main(args: Array[String]): Unit = {
        val sum = subarraySum(Array(1, 1, 1), 2)
        assert(sum == 2)
    }
}
