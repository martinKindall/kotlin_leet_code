package easy

class NumberRectanglesLargestSquare {
    fun countGoodRectanglesAlternative(rectangles: Array<IntArray>): Int {
        // just get the min side from every rectangle
        // then get the max number along the list
        // and simultaneously count each repetition

        // time complexity O(N) + O(N)

        val minSides = rectangles.map {
            Math.min(it[0], it[1])
        }

        val countMap = HashMap<Int, Int>()
        var currMax = 0

        minSides.forEach {
            if (it > currMax) currMax = it
            countMap[it] = (countMap[it] ?: 0) + 1
        }
        return countMap[currMax] ?: 0
    }

    fun countGoodRectangles(rectangles: Array<IntArray>): Int {
        val minSides = rectangles.map {
            Math.min(it[0], it[1])
        }

        val currMax = minSides.reduce { acc, i ->
            if (acc < i) i else acc
        }

        return minSides.count {
            it == currMax
        }
    }
}