class Node(var _value: Int) {
    var value: Int = _value
    var children: List[Node] = List()
}

object Solution {
    def findRoot(tree: List[Node]): Node = {
        // each node has a unique value
        val seen: List[Node] = tree.foldLeft(List[Node]()){ case (x, y) ⇒ x ::: y.children }
        val root = tree.filterNot(x ⇒ seen.map(_.value).contains(x.value)).last
        root
    }

    def main(args: Array[String]): Unit = {
        val node1 = new Node(1)
        val node2 = new Node(2)
        val node3 = new Node(3)
        val node4 = new Node(4)
        val node5 = new Node(5)
        val node6 = new Node(6)

        node1.children = node3::node2::node4::node1.children
        node3.children = node5::node6::node3.children

        var tree: List[Node] = List()
        tree = node1::node2::node3::node4::node5::node6::tree

        val root: Node = findRoot(tree)
        assert(1 == root.value)
    }
}
