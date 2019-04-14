package RootedTree

import java.util.NoSuchElementException

import scala.collection.mutable.ArrayBuffer

class Tree {
  private var root: Option[Leaf] = None

  def appendRoot(newLeaf: Leaf): Unit = {
    root = Option(newLeaf)
  }

  def getRoot : Leaf = {
    root.getOrElse(throw new NoSuchElementException("There's no root defined"))
  }

  def appendLeafToParent(newLeaf: Leaf, parentLeaf: Leaf): Unit = {
    newLeaf.parent = Option(parentLeaf)
    if (parentLeaf.leftChild.isEmpty) {
      parentLeaf.leftChild = Option(newLeaf)
    }
    else {
      var currentRightSibling: Option[Leaf] = parentLeaf.leftChild.get.rightSibling
      var previousRightSibling: Option[Leaf] = parentLeaf.leftChild
      while (currentRightSibling.isDefined) {
        previousRightSibling = currentRightSibling
        currentRightSibling = currentRightSibling.get.rightSibling
      }
      previousRightSibling.get.rightSibling = Option(newLeaf)
      currentRightSibling = Option(newLeaf)
    }
  }

  @Override
  override def toString: String = {
    val response: StringBuilder = new StringBuilder
    val queue: ArrayBuffer[Leaf] = new ArrayBuffer[Leaf]
    if (root.isDefined) {
      queue += root.get
      while (queue.nonEmpty) {
        val currentLeaf: Leaf = queue(0)
        var currentRightSibling = currentLeaf.rightSibling
        while (currentRightSibling.isDefined) {
          queue +=  currentRightSibling.get
          currentRightSibling = currentRightSibling.get.rightSibling
        }
        if (currentLeaf.leftChild.isDefined) queue += currentLeaf.leftChild.get
        response.append(queue(0).toString)
        if (currentLeaf.rightSibling.isEmpty) response.append("\n") else response.append(" ")
        queue.remove(0)
      }
    }
    else response.append("Tree is empty")
    response.toString()
  }
}
