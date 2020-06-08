package kr.iannam.study

object Solution  {

    def main(args: Array[String]) {

        val coins: Array[Int] = Array(1, 2, 5)
        val amount = 5

        print(change(5, coins))
    }

    def change(amount: Int, coins: Array[Int]): Int = {
        val d = Array.fill(amount + 1)(0)
        d(0) = 1
        for {
            coin <- coins
            i <- 1 to amount
            if i >= coin
        } d(i) = d(i) + d(i - coin)
        d.last
    }
}
