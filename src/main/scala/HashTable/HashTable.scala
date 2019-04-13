package HashTable

import scala.collection.mutable.ListBuffer

class HashTable {
  val tableSize: Int = 128
  private val table: Array[Option[ListBuffer[HashEntry]]] = Array.fill[Option[ListBuffer[HashEntry]]](128)(None)

  def put(key: String, value: String): Int = {
    val index: Int = hash(key)
    val entry: HashEntry = new HashEntry(key, value)
    var chain: ListBuffer[HashEntry] = if(table(index).isEmpty) ListBuffer() else table(index).get
    chain = chain.filter(_.key != key)
    chain += entry
    table(index) = Option.apply(chain)
    index
  }

  def get(key: String) : String = {
    val index: Int = hash(key)
    var chain: ListBuffer[HashEntry] = if(table(index).isDefined) table(index).get else throw new NoSuchElementException("This key(" + key + ") does not exist.")
    chain = chain.filter(_.key == key)
    chain.head.toString
  }

  private def hash(key: String) : Int = {
    key.map(_.asDigit).hashCode() % tableSize
  }

}
