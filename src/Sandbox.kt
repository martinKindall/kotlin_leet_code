class Solution {
    companion object {
        fun anagramMappings(nums1: IntArray, nums2: IntArray): IntArray {
            return nums1.map {
                nums2.indexOf(it)
            }.toIntArray()
        }

        fun calculateTime2(keyboard: String, word: String): Int {
            // iterar sobre word
            // definir inicio = 0
            // acumular el tiempo de iteracion en iteracion con la formula
            // -> |i - j|

            var indexActual = 0
            var tiempoAcumulado = 0

            word.forEach { charActual ->
                val indexIteracion = keyboard.indexOf(charActual)
                tiempoAcumulado += Math.abs(indexIteracion - indexActual)
            }

            return tiempoAcumulado
        }

        fun mostWordsFound2(sentences: Array<String>): Int {
            var maxWords = 0

            sentences.forEach { sentence ->
                sentence.split(" ").size.let { size ->
                    if (size > maxWords)
                        maxWords = size
                }
            }

            return maxWords
        }

        fun mostWordsFound(sentences: Array<String>): Int {
            return sentences.map {
                it.split(" ").size
            }.reduce { acc, num ->
                if (acc > num) acc else num
            }
        }
    }
}
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution2 {
    fun getLonelyNodes(root: TreeNode?): List<Int> {
        if (root == null || root.left == null && root.right == null) return listOf()

        val rootLeft = root.left
        if (rootLeft != null && root.right == null) {
            return arrayListOf(rootLeft.`val`) + getLonelyNodes(root.left)
        }

        val rootRight = root.right
        return if (root.left == null && rootRight != null) {
            arrayListOf(rootRight.`val`) + getLonelyNodes(root.right)
        }
        else {
            getLonelyNodes(root.right) + getLonelyNodes(root.left)
        }
    }
}