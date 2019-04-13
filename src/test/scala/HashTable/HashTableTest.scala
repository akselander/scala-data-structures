package HashTable

import java.util.NoSuchElementException

import org.scalatest.FlatSpec

class HashTableTest extends FlatSpec {

  "Put, get" should "put key on valid index, get should retrieve value by key" in {
    val hashTable: HashTable = new HashTable
    hashTable.put("sad", "happy")
    val response: String = hashTable.get("sad")
    assert(response === "happy")
  }

  "Get" should "throw an error when provided with bad key" in {
    val hashTable: HashTable = new HashTable
    hashTable.put("sad", "happy")
    try {
      hashTable.get("bad")
    }
    catch {
      case e: NoSuchElementException => assert(e.getMessage === "This key(bad) does not exist.")
    }
  }
}
