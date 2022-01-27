package easy

class NumberStringAppearsAsSubstring {
    fun numOfStrings(patterns: Array<String>, word: String): Int {
        return patterns.map {
            if (word.contains(it)) 1 else 0
        }.sum()
    }
}