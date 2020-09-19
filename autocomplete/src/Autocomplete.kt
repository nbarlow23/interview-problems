fun main() {
    val words = Autocomplete()
    words.insert("Quastor")
    words.insert("Coding")
    println(words.search("Quastor")) // True
    println(words.search("Interview")) // False
    println(words.startsWith("Qu")) // True
    println(words.startsWith("Ca")) // False
}

class TrieNode {
    var isWord: Boolean = false
    private val children = mutableMapOf<Char, TrieNode>()
    fun addLetter(letter: Char): TrieNode {
        return children.getOrPut(letter) { TrieNode() }
    }

    fun child(letter: Char): TrieNode? {
        return children[letter]
    }
}

class Autocomplete {
    private val root = TrieNode()

    fun insert(word: String) {
        val finalNode = word.fold(root) { node, letter ->
            return@fold node.addLetter(letter)
        }
        finalNode.isWord = true
    }

    fun search(word: String): Boolean {
        val finalNode = word.fold(root) { node, letter ->
            return@fold node.child(letter) ?: return false
        }
        return finalNode.isWord
    }

    fun startsWith(prefix: String): Boolean {
        prefix.fold(root) { node, letter ->
            return@fold node.child(letter) ?: return false
        }
        return true
    }
}