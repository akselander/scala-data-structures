package RootedTreeTest

import RootedTree.{Leaf, Tree}
import org.scalatest.FlatSpec

class TreeTest extends FlatSpec {

  "Append Root" should "append leaf to the root" in {
    val tree: Tree = new Tree
    tree.appendRoot(new Leaf("A"))
  }

  "Append Leaf to Parent" should "append leaf to the parent" in {
    val tree: Tree = new Tree
    val rootLeaf: Leaf = new Leaf("A")
    val leaf: Leaf = new Leaf("B")
    val leaf2: Leaf = new Leaf("C")
    tree.appendRoot(rootLeaf)
    tree.appendLeafToParent(leaf, rootLeaf)
    tree.appendLeafToParent(leaf2, rootLeaf)
    assert(rootLeaf.leftChild.get === leaf)
    assert(leaf.parent.get === rootLeaf)
  }

  "To String" should "return tree as a String" in {
    val tree: Tree = new Tree
    val rootLeaf: Leaf = new Leaf("A")
    val leaf: Leaf = new Leaf("B")
    val leaf2: Leaf = new Leaf("C")
    val response1: String = "Tree is empty"
    assert(tree.toString === response1)
    val response2: String = "Leaf: A\nLeaf: B Leaf: C\n"
    tree.appendRoot(rootLeaf)
    tree.appendLeafToParent(leaf, rootLeaf)
    tree.appendLeafToParent(leaf2, rootLeaf)
    assert(tree.toString === response2)
  }
}
