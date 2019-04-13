package RootedTree

class Leaf(leafKey: String) {
  val key: String = leafKey
  var parent: Option[Leaf] = None
  var leftChild: Option[Leaf] = None
  var rightSibling: Option[Leaf] = None

  @Override
  override def toString: String = "Leaf: " + key

}
