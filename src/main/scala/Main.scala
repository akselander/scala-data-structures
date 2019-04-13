package main.scala

import main.scala.LinkedList.{Node, MyDoubleLinkedList}

object Main extends App {

  println("Double Linked List")
  val doubleLinkedList: MyDoubleLinkedList = new MyDoubleLinkedList()
  doubleLinkedList.insert(new Node("A"))
  doubleLinkedList.insert(new Node("B"))
  doubleLinkedList.insert(new Node("C"))
  println("Insert three nodes at the head")
  println(doubleLinkedList.toString)
  println("Remove second node by using search and delete")
  doubleLinkedList.delete(doubleLinkedList.search("B"))
  println(doubleLinkedList.toString)
}
