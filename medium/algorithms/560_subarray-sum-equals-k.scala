object Solution {
    type d3 = (Int, Int)

    def update(k: Int)(p: d3, num: Int): d3 = p match {
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
            nums.slice(x, nums.length).foldLeft(init)(update(k))._2
        }.sum
    }

    def main(args: Array[String]): Unit = {
        val sum = subarraySum(Array(1, 1, 1), 2)
        assert(sum == 2)
    }
}
