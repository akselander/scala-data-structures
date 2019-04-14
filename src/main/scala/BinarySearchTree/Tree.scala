package BinarySearchTree

import java.util.NoSuchElementException

class Tree {
  private var root: Option[Leaf] = None

  def getRoot : Leaf = {
    root.getOrElse(throw new NoSuchElementException("There's no root defined"))
  }

  def inorderTreeWalk(leaf: Option[Leaf]): Unit = {
    if(leaf.isDefined) {
      inorderTreeWalk(leaf.get.leftChild)
      print(leaf.get.key)
      inorderTreeWalk(leaf.get.rightChild)
    }
  }

  def treeSearch(leaf: Option[Leaf], key: Int) : Option[Leaf] = {
    var returnLeaf: Option[Leaf] = None
    if(leaf.isEmpty || key == leaf.get.key) returnLeaf = leaf else if(key < leaf.get.key) returnLeaf = treeSearch(leaf.get.leftChild, key) else returnLeaf = treeSearch(leaf.get.rightChild, key)
    returnLeaf
  }

  def iterativeTreeSearch(leaf: Option[Leaf], key: Int) : Option[Leaf] = {
    var returnLeaf: Option[Leaf] = leaf
    while(returnLeaf.isDefined && returnLeaf.get.key != key) {
      returnLeaf = if(key < leaf.get.key) leaf.get.leftChild else leaf.get.rightChild
    }
    returnLeaf
  }

  def minimum(leaf: Leaf) : Option[Leaf] = {
    var currentLeaf: Option[Leaf] = Option(leaf)
    while(currentLeaf.get.leftChild.isDefined) currentLeaf = currentLeaf.get.leftChild
    currentLeaf
  }

  def maximum(leaf: Leaf) : Option[Leaf] = {
    var currentLeaf: Option[Leaf] = Option(leaf)
    while(currentLeaf.get.rightChild.isDefined) currentLeaf = currentLeaf.get.rightChild
    currentLeaf
  }

  def successor(leaf: Leaf) : Option[Leaf] = {
    var currentLeaf: Option[Leaf] = Option(leaf)
    var parentLeaf: Option[Leaf] = currentLeaf.get.parent
    if(currentLeaf.get.rightChild.isDefined) {
      minimum(currentLeaf.get.rightChild.get)
      parentLeaf = currentLeaf.get.parent
    }
    else {
      while (parentLeaf.isDefined && currentLeaf == parentLeaf.get.rightChild) {
        currentLeaf = parentLeaf
        parentLeaf = parentLeaf.get.parent
      }
    }
    parentLeaf
  }

  def insert(leaf: Leaf) : Unit = {
    var parentLeaf: Option[Leaf] = None
    var currentLeaf: Option[Leaf] = root
    while(currentLeaf.isDefined) {
      parentLeaf = currentLeaf
      currentLeaf = if(leaf.key < currentLeaf.get.key)  currentLeaf.get.leftChild else currentLeaf.get.rightChild
    }
    leaf.parent = parentLeaf
    if(parentLeaf.isEmpty) root = Option(leaf) else if(leaf.key < parentLeaf.get.key) parentLeaf.get.leftChild = Option(leaf) else parentLeaf.get.rightChild = Option(leaf)
  }


}
