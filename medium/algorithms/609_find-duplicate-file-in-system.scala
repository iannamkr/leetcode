object Solution {
  def findDuplicate(paths: Array[String]):  List[List[String]] = {
    val filePaths = paths
      .map(_.split(" "))
      .flatMap { x => x.tail.map(y => (x.head, y)) }
      .map { case (x, y) =>
        val open = y.lastIndexOf("(") + 1
        val close = y.indexOf(")", open)
        val file = y.substring(0, open - 1)
        val content = y.substring(open, close)
        (content, s"$x/$file")
      }
    val duplicates = filePaths.groupBy(_._1).filter(_._2.length > 1).mapValues(_.map(_._2)).map(_._2.toList).toList
    duplicates
  }
}
