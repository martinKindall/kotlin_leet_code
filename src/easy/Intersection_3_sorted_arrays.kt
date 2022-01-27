package easy

class Intersection_3_sorted_arrays {

    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {
        // a solution is to merge all the three arrays in a sorted one

        // then filter the elements that are present only on the three arrays
        // we can check if an element is present in the three arrays using 3 sets
        // and querying each one

        // finally we remove the repeated elements

        val set1 = mutableSetOf<Int>()
        val set2 = mutableSetOf<Int>()
        val set3 = mutableSetOf<Int>()

        listOf(Pair(set1, arr1), Pair(set2, arr2), Pair(set3, arr3)).forEach {
            it.second.forEach { aNumber ->
                it.first.add(aNumber)
            }
        }

        val repeatedSets = mutableSetOf<Int>()
        return merge(merge(arr1, arr2), arr3).filter {
            set1.contains(it) && set2.contains(it) && set3.contains(it)
        }.filter {
            if (repeatedSets.contains(it)) {
                false
            } else {
                repeatedSets.add(it)
                true
            }
        }
    }

    fun merge(arr1: IntArray, arr2: IntArray): IntArray {
        val arrSorted = IntArray(arr1.size + arr2.size)

        var idx1 = 0
        var idx2 = 0
        var idxSorted = 0

        while (idx1 < arr1.size && idx2 < arr2.size) {
            if (arr1[idx1] > arr2[idx2]) {
                arrSorted[idxSorted] = arr2[idx2]
                idx2 += 1
            } else if (arr1[idx1] <= arr2[idx2]) {
                arrSorted[idxSorted] = arr1[idx1]
                idx1 += 1
            }
            idxSorted += 1
        }

        if (idx1 < arr1.size - 1) {
            for (i in idx1 until arr1.size) {
                arrSorted[idxSorted] = arr1[i]
                idxSorted += 1
            }
        } else if (idx2 < arr2.size - 1) {
            for (i in idx2 until arr2.size) {
                arrSorted[idxSorted] = arr2[i]
                idxSorted += 1
            }
        }

        return arrSorted
    }
}