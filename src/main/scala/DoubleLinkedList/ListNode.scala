package DoubleLinkedList

class ListNode(nodeKey: String) {
  val key: String = nodeKey
  var next: Option[ListNode] = None
  var prev: Option[ListNode] = None

  @Override
  override def toString: String = "Node: " + key
}
