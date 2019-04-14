package BinarySearchTree

import org.scalatest.{BeforeAndAfterEach, FlatSpec}

class BSTreeTest extends FlatSpec with BeforeAndAfterEach{
  var tree: Tree = new Tree
  val rootLeaf = new Leaf(6)
  val leaves: Array[Int] = Array(15, 6, 18, 3, 7, 17, 20, 2, 4, 13, 9)
  val leaf1: Leaf = new Leaf(5)
  val leaf2: Leaf = new Leaf(7)

  override def beforeEach(): Unit = {
    tree = new Tree
    tree.insert(rootLeaf)
    super.beforeEach()
  }

  "Append Root" should "append leaf to the root" in {
    assert(rootLeaf === tree.getRoot)
  }

  "Insert" should "append leaves depending on key" in {
    tree.insert(leaf1)
    tree.insert(leaf2)
    assert(leaf1.parent.get === tree.getRoot)
    assert(leaf2.parent.get === tree.getRoot)
    assert(leaf1 === tree.getRoot.leftChild.get)
    assert(leaf2 === tree.getRoot.rightChild.get)
  }

  "Inorder Walk" should "Print Subtree Root between subtrees" in {
    tree.inorderTreeWalk(Option(tree.getRoot))
  }

  "Tree Search" should "find Leaf by key" in {
    assert(leaf1 === tree.treeSearch(Option(tree.getRoot), 5).get)
  }

  "Iterative Search" should "find Leaf by key" in {
    assert(leaf1 === tree.iterativeTreeSearch(Option(tree.getRoot), 5).get)
  }

  "Minimum" should "find minimum" in {
    assert(tree.minimum(tree.getRoot).get.key === 5)
  }

  "Maximum" should "find maximum" in {
    assert(tree.maximum(tree.getRoot).get.key === 7)
  }

  "Successor" should "find leafs successsor" in {
    assert(tree.successor(leaf1) === Option(tree.getRoot))
  }

}
