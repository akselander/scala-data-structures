package main.scala.LinkedList

class MyDoubleLinkedList {
  private var head: Option[Node] = None

  def insert(newNode: Node) : Unit = {
    newNode.next = head
    if (head.isDefined) head.get.prev = Option.apply(newNode)
    head = Option.apply(newNode)
    newNode.prev = None
  }

  def search(searchedKey: String) : Node = {
    var node: Option[Node] = head
    while(node.isDefined && node.get.key != searchedKey) {
      node = node.get.next
    }
    node.get
  }

  def delete(node: Node) : Unit = {
    if(node.prev.isDefined) node.prev.get.next = node.next else head = node.next
    if(node.next.isDefined) node.next.get.prev = node.prev
  }

  @Override
  override def toString: String = {
    var node: Option[Node] = head
    val response: StringBuilder = new StringBuilder("")
    while(node.isDefined){
      response.append(node.get.toString)
      if(node.get.next.isDefined) response.append(" => ")
      node = node.get.next
    }
    response.toString()
  }
}
