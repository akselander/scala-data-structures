package BinarySearchTree

class Leaf(leafKey: Int) {
  val key: Int = leafKey
  var parent: Option[Leaf] = None
  var leftChild: Option[Leaf] = None
  var rightChild: Option[Leaf] = None

  @Override
  override def toString: String = "Leaf: " + key.toString

}
