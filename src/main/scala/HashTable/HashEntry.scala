package HashTable

class HashEntry(hashKey: String, newValue: String) {
  val key: String = hashKey
  val value: String = newValue

  @Override
  override def toString: String = value
}
