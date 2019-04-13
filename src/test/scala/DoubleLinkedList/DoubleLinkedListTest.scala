package DoubleLinkedList

import main.scala.DoubleLinkedList.{DoubleLinkedList, ListNode}
import org.scalatest.FlatSpec

class DoubleLinkedListTest extends FlatSpec {

  "Insert" should "insert new node at the element" in {
    val doubleLinkedList: DoubleLinkedList = new DoubleLinkedList()
    doubleLinkedList.insert(new ListNode("A"))
    assert(doubleLinkedList.toString === "Node: A")
  }

  "Search" should "return node with provided key" in {
    val doubleLinkedList: DoubleLinkedList = new DoubleLinkedList()
    val newNode: ListNode = new ListNode("A")
    doubleLinkedList.insert(newNode)
    val node: ListNode = doubleLinkedList.search("A")
    assert(newNode.equals(node))
  }

  "Delete" should "delete node from list" in {
    val doubleLinkedList: DoubleLinkedList = new DoubleLinkedList()
    val node = new ListNode("A")
    doubleLinkedList.insert(node)
    doubleLinkedList.insert(new ListNode("B"))
    doubleLinkedList.delete(node)
    assert(doubleLinkedList.toString === "Node: B")
  }

  "toString" should "add arrows between nodes" in {
    val doubleLinkedList: DoubleLinkedList = new DoubleLinkedList()
    doubleLinkedList.insert(new ListNode("A"))
    doubleLinkedList.insert(new ListNode("B"))
    assert(doubleLinkedList.toString === "Node: B => Node: A")
  }
}
