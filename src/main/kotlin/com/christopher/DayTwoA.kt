package com.christopher

fun findIdChecksum(idList: List<String>): Int {
    val (doubleCount, tripleCount) = idList.map {
        var isDouble = false
        var isTriple = false
        val map: MutableMap<Char, Int> = HashMap()
        for (letter in it) {
            if (letter in map) map[letter] = map[letter]!! + 1
            else map[letter] = 1
        }
        for (value in map.values) {
            if (value == 2) isDouble = true
            if (value == 3) isTriple = true
        }
        Pair(if (isDouble) 1 else 0, if (isTriple) 1 else 0)
    }.reduce { acc, next -> Pair(acc.first + next.first, acc.second + next.second) }
    return doubleCount * tripleCount
}