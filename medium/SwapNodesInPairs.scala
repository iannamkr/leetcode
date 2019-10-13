package leetcode

object SwapNodesInPairs {
  class ListNode(var _x: Int = 0) {
    var next: ListNode = null
    var x: Int = _x

    def next(node: ListNode): Unit = {
      this.next = node
    }
  }

  def swapPairs(head: ListNode): ListNode =  {
    if(head != null && head.next != null) {
      val tmp = head.x
      head.x = head.next.x
      head.next.x = tmp
      swapPairs(head.next.next)
      head
    } else {
      head
    }
  }

  def printListNode(node: ListNode): Unit = {
    print(node.x)
    if(node.next != null) {
      print(" -> ")
      printListNode(node.next)
    }
    println()
  }

  def main(args: Array[String]): Unit = {
    var node1 = new ListNode(1)
    var node2 = new ListNode(2)
    var node3 = new ListNode(3)
    var node4 = new ListNode(4)

    node1.next(node2)
    node2.next(node3)
    node3.next(node4)

    swapPairs(node1)
    printListNode(node1)
  }
}
