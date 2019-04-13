package main.scala.LinkedList

class Node(nodeKey: String) {
  val key: String = nodeKey
  var next: Option[Node] = None
  var prev: Option[Node] = None

  @Override
  override def toString: String = "Node: " + key
}
