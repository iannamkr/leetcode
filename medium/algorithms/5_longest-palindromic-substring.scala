object Solution {
  def longestPalindrome(s: String): String = {
    Option(s) match {
      case None  => s
      case _ => findPalindrome(s.length, s)
    }
    
    def findPalindrome(w: Int, s: String): String = {
      val palindrome = s.sliding(w).filter{ s => s.equals(s.reverse) }
      if(palindrome.nonEmpty) {
        palindrome.toList.last
      } else {
        findPalindrome(w - 1, s)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("bccc"))
  }
}
