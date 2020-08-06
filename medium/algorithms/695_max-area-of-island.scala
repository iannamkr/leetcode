object Solution {
    def maxAreaOfIsland(grid: Array[Array[Int]]): Int = {
        def dfs(i: Int, j: Int): Int = {
            if ((0 <= i && i < grid.length) && (0 <= j && j < grid(0).length) && grid(i)(j) == 1) {
                grid(i)(j) = 0
                1 + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i + 1, j) + dfs(i, j - 1)
            } else {
                0
            }
        }

        val areas = for (
            i <- grid.indices;
            j <- grid(0).indices
            if grid(i)(j) == 1
        ) yield dfs(i, j)

        val maxArea = if(areas.size > 0) areas.max else 0
        maxArea
    }

    def main(args: Array[String]): Unit = {
        val island: Array[Array[Int]] =
            Array(
                Array(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
                Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                Array(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
                Array(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
                Array(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
                Array(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
                Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
                Array(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0)
            )
        val maxArea = maxAreaOfIsland(island)
        assert(maxArea == 4)
    }
}
