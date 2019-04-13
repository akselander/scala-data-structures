package DoubleLinkedList

class DoubleLinkedList {
  private var head: Option[ListNode] = None

  def insert(newNode: ListNode) : Unit = {
    newNode.next = head
    if (head.isDefined) head.get.prev = Option.apply(newNode)
    head = Option.apply(newNode)
    newNode.prev = None
  }

  def search(searchedKey: String) : ListNode = {
    var node: Option[ListNode] = head
    while(node.isDefined && node.get.key != searchedKey) {
      node = node.get.next
    }
    node.get
  }

  def delete(node: ListNode) : Unit = {
    if(node.prev.isDefined) node.prev.get.next = node.next else head = node.next
    if(node.next.isDefined) node.next.get.prev = node.prev
  }

  @Override
  override def toString: String = {
    var node: Option[ListNode] = head
    val response: StringBuilder = new StringBuilder("")
    while(node.isDefined){
      response.append(node.get.toString)
      if(node.get.next.isDefined) response.append(" => ")
      node = node.get.next
    }
    response.toString()
  }
}
