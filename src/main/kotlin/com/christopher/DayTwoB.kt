package com.christopher

fun findCommonIds(idList: List<String>): String {
    for (id in idList) {
        for (other in idList) {
            var count = 0
            if (id === other) continue
            val wordSize = id.length
            var common = ' '
            for (i in 0 until wordSize) {
                if (id[i] != other[i]) {
                    count++
                    common = id[i]
                }
            }
            if (count == 1) {
                return id.toCharArray().filter { it != common }.joinToString("")
            }
        }
    }
    return ""
}