package easy

class FindNUniqueIntSum0 {
    fun sumZero(n: Int): IntArray {
        var startingPoint = (Math.random() * 100).toInt()
        val result = IntArray(n)

        var idx = 0
        while (idx < n - 1) {
            result[idx] = startingPoint
            idx += 1
            startingPoint += 1
        }

        val currSum = result.sum()
        result[idx] = -currSum
        return result
    }

    fun sumZeroBruteForce(n: Int): IntArray {
        // brute force would suggest generating random unique numbers
        // for the first n-1 elements, and then the n element should be
        // the number that sets the result to 0. If it is a repeated number
        // repeat everything
        val result = IntArray(n)
        var idx = 0
        val currentNums = mutableSetOf<Int>()

        while (idx < result.size) {
            if (idx < result.size - 1) {
                val nextNum = (Math.random() * 10000).toInt()
                if (!currentNums.contains(nextNum)) {
                    currentNums.add(nextNum)
                    result[idx] = nextNum
                    idx += 1
                }
            } else {
                val accSum = result.sum()
                val finalNum = -accSum
                if (currentNums.contains(finalNum)) {
                    idx = 0
                    currentNums.clear()
                } else {
                    result[idx] = finalNum
                    break
                }
            }
        }

        return result
    }
}